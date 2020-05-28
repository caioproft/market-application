package com.pocs.MarketProject.controller;

import com.pocs.MarketProject.domain.dto.UserDTO;
import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController( UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO){
        User user = userService.create(userDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
