package com.clickhealth.pharma.services;

import com.clickhealth.pharma.entity.UserEntity;
import com.clickhealth.pharma.user.model.CreateUserRequest;
import com.clickhealth.pharma.user.model.Role;
import com.clickhealth.pharma.user.model.User;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    User getById(Integer id);
    User create(CreateUserRequest request);
    User update(Integer id, CreateUserRequest user); // Still uses full DTO for updates
    void delete(Integer id);
    List<Role> getAllRoles();
    User authenticate(@NotNull String username, @NotNull String password);

}
