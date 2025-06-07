package com.clickhealth.pharma.controller;

import com.clickhealth.pharma.user.api.RolesApi;
import com.clickhealth.pharma.user.model.Role;
import com.clickhealth.pharma.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController implements RolesApi {

    private static final Logger log = LoggerFactory.getLogger(RoleController.class);

    private final UserService userService;

    public RoleController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<Role>> listRoles() {
        return ResponseEntity.ok(userService.getAllRoles());
    }
}
