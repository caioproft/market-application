package com.pocs.MarketProject.service;

import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.domain.request.UserCreateRequest;
import com.pocs.MarketProject.domain.response.UserResponse;
import com.pocs.MarketProject.exceptions.UserExistsException;
import com.pocs.MarketProject.mapper.UserMapper;
import com.pocs.MarketProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public void createUser(UserCreateRequest userCreateRequest){
        User user = userRepository.findByEmail(userCreateRequest.getEmail());
        if(user == null){
            user = userMapper.userCreateRequestToUser(userCreateRequest);
            userRepository.save(user);
        }else {
            throw new UserExistsException("Já existe um usuário cadastrado com esse e-mail.");
        }
    }

    public List<UserResponse> findAll() {
        List<User> userList = userRepository.findAll();
        List<UserResponse> userResponseList = new ArrayList<>();

        for(User user : userList){
            userResponseList.add(userMapper.userToUserResponse(user));
        }

        return userResponseList;
    }
}
