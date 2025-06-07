package com.clickhealth.pharma.mapper;

import com.clickhealth.pharma.entity.UserEntity;
import com.clickhealth.pharma.enums.Role; // internal enum
import com.clickhealth.pharma.user.model.CreateUserRequest;
import com.clickhealth.pharma.user.model.User;
import com.clickhealth.pharma.utils.DateTimeUtils;

public class UserMapper {

    public static User toDto(UserEntity entity) {
        if (entity == null) return null;

        return new User()
                .id(entity.getId())
                .username(entity.getUsername())
                .role(toApiRole(entity.getRole()))
                .status(User.StatusEnum.valueOf(entity.getStatus().name()))
                .lastLoginAt(entity.getLastLoginAt()) // assuming OpenAPI model uses OffsetDateTime
                .failedLoginAttempts(entity.getFailedLoginAttempts())
                .createdAt(entity.getCreatedAt())
                .createdBy(entity.getCreatedBy())
                .updatedAt(entity.getUpdatedAt())
                .updatedBy(entity.getUpdatedBy());
    }

    public static UserEntity toEntity(CreateUserRequest request) {
        if (request == null) return null;

        return UserEntity.builder()
                .username(request.getUsername())
                .password(request.getPassword())
                .role(toInternalRole(request.getRole()))
                .build();
    }

    private static com.clickhealth.pharma.user.model.Role toApiRole(Role internalRole) {
        return com.clickhealth.pharma.user.model.Role.valueOf(internalRole.name());
    }

    private static Role toInternalRole(CreateUserRequest.RoleEnum roleEnum) {
        return Role.valueOf(roleEnum.name());
    }
}
