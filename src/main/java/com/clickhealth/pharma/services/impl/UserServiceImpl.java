package com.clickhealth.pharma.services.impl;

import com.clickhealth.pharma.entity.SupplierEntity;
import com.clickhealth.pharma.entity.UserEntity;
import com.clickhealth.pharma.enums.UserStatus;
import com.clickhealth.pharma.mapper.SupplierMapper;
import com.clickhealth.pharma.mapper.UserMapper;
import com.clickhealth.pharma.repository.UserRepository;
import com.clickhealth.pharma.services.UserService;
import com.clickhealth.pharma.user.model.CreateUserRequest;
import com.clickhealth.pharma.user.model.Role;
import com.clickhealth.pharma.user.model.User;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public User getById(Integer id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        return entity.map(UserMapper::toDto).orElse(null);
    }

    @Override
    public User create(CreateUserRequest request) {
        UserEntity entity = UserMapper.toEntity(request);
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        entity.setStatus(UserStatus.ACTIVE); // Default status
        UserEntity saved = userRepository.save(entity);
        log.info("Created user: {}", saved.getUsername());
        return UserMapper.toDto(saved);
    }

    @Override
    public User update(Integer id, CreateUserRequest request) {
        if (!userRepository.existsById(id)) {
            return null;
        }
        UserEntity entity = UserMapper.toEntity(request);
        entity.setId(id);
        UserEntity updated = userRepository.save(entity);
        log.info("Updated user ID {}: {}", id, updated.getUsername());
        return UserMapper.toDto(updated);

    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
        log.info("Deleted user ID {}", id);
    }

    @Override
    public List<Role> getAllRoles() {
        return List.of(Role.values());
    }

    @Override
    public User authenticate(@NotNull String username, @NotNull String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return UserMapper.toDto(user);
        }else{
            log.error("Login Failed : Invalid Password for User {}",username);
            return null;
        }
    }
}
