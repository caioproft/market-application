package com.pocs.MarketProject.service;

import com.pocs.MarketProject.domain.dto.UserRequestDTO;
import com.pocs.MarketProject.domain.dto.UserResponseDTO;
import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.exceptions.UserNotFound;
import com.pocs.MarketProject.mapper.UserRequestMapper;
import com.pocs.MarketProject.mapper.UserResponseMapper;
import com.pocs.MarketProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserRequestMapper userRequestMapper,
                       UserResponseMapper userResponseMapper){
        this.userRepository = userRepository;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }

    public User create(UserRequestDTO userRequestDTO){

        User user = userRequestMapper.UserDTOToUser(userRequestDTO);
        userRepository.save(user);
        return user;
    }

    public UserResponseDTO finById(Long id){

        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFound("Usuário não encontrado."));

        return userResponseMapper.userToUserResponseDTO(user);
    }

    public List<UserResponseDTO> findAll(){
        List<User> userList = userRepository.findAll();
        return userResponseMapper.userListToUserReponseDTO(userList);
    }


}
