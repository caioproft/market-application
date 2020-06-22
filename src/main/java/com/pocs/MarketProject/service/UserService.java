package com.pocs.MarketProject.service;

import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.domain.request.UserCreateRequest;
import com.pocs.MarketProject.domain.request.UserUpdateRequest;
import com.pocs.MarketProject.domain.response.UserResponse;
import com.pocs.MarketProject.exceptions.ResourceNotFound;
import com.pocs.MarketProject.exceptions.UserExistsException;
import com.pocs.MarketProject.exceptions.UserNotFound;
import com.pocs.MarketProject.mapper.UserMapper;
import com.pocs.MarketProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Transactional
    public void createUser(UserCreateRequest userCreateRequest){
        boolean exists = userRepository.existsByEmail(userCreateRequest.getEmail());
        if(exists){
            throw new UserExistsException("E-mail já cadastrado");
        }
        User user = userMapper.userCreateRequestToUser(userCreateRequest);
        userRepository.save(user);
    }

    @Transactional
    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();

        for(User user : userList){
            userResponseList.add(userMapper.userToUserResponse(user));
        }

        return userResponseList;
    }

    @Transactional
    public UserResponse findById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Usuário não cadastrado."));
        UserResponse userResponse = userMapper.userToUserResponse(user);
        return userResponse;
    }

    @Transactional
    public void delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Usuário não encontrado."));
        userRepository.delete(user);
    }

    @Transactional
    public UserResponse update(Long id, UserUpdateRequest userUpdateRequest){
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFound("Usuário não cadastrado."));
        userMapper.userUpdateRequestToUser(user, userUpdateRequest);
        UserResponse userResponse = userMapper.userToUserResponse(user);

        return userResponse;
    }

}
