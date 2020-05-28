package com.pocs.MarketProject.controller;

import com.pocs.MarketProject.domain.dto.UserRequestDTO;
import com.pocs.MarketProject.domain.dto.UserResponseDTO;
import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController( UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll(){

        List<UserResponseDTO> userResponseList = userService.findAll();
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findOne(@PathVariable Long id){
        UserResponseDTO userResponse = userService.finById(id);

        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserRequestDTO userRequestDTO){
        User user = userService.create(userRequestDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

}
