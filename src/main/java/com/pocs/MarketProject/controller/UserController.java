package com.pocs.MarketProject.controller;


import com.pocs.MarketProject.domain.request.UserCreateRequest;
import com.pocs.MarketProject.domain.request.UserUpdateRequest;
import com.pocs.MarketProject.domain.response.UserResponse;
import com.pocs.MarketProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody UserCreateRequest userCreateRequest){
        userService.createUser(userCreateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserResponse>> findAll(){
        List<UserResponse> userResponseList = userService.findAll();
        return new ResponseEntity<>(userResponseList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponse> findbyId(@PathVariable Long id){
        UserResponse userResponse = userService.findById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(path = "/{id}" )
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UserUpdateRequest userUpdateRequest){
        UserResponse userResponse = userService.update(id, userUpdateRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

}
