package com.pocs.MarketProject.service;

import com.pocs.MarketProject.domain.dto.UserDTO;
import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.mapper.UserMapper;
import com.pocs.MarketProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public User create(UserDTO userDTO){

        User user = userMapper.UserDTOToUser(userDTO);
        userRepository.save(user);

        return user;
    }
}
