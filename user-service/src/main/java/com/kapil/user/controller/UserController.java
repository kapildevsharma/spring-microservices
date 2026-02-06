package com.kapil.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kapil.user.VO.ResponseTemplateVO;
import com.kapil.user.entity.User;
import com.kapil.user.service.UserService;

@RestController
@Tag(name = "User APIs", description = "Operations related to User Management")
@RequestMapping("/users")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/")
    @Operation(summary = "Save User", description = "Create a new user in the system")

    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get User by user id" , description = "Get user details along with department information by user id")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }


}
