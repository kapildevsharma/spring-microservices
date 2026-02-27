package com.kapil.user.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.kapil.user.VO.ResponseTemplateVO;
import com.kapil.user.entity.User;
import com.kapil.user.service.UserService;

import java.util.List;

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

    @GetMapping()
    @Operation(summary = "Get Users" , description = "Get user details along with department information")
    public List<ResponseTemplateVO> getUserListWithDepartment() {
        log.info("Inside getUsers of UserController");
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get User by user id" , description = "Get user details along with department information by user id")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete User by user id" , description = "Delete user details by user id")
    public String deleteUser(@PathVariable("id") Long userId) {
        log.info("Inside deleteUser of UserController");
        userService.deleteUser(userId);
        return "User with id " + userId + " deleted successfully.";
    }

}
