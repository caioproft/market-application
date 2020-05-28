package com.pocs.MarketProject.mapper;

import com.pocs.MarketProject.domain.dto.UserResponseDTO;
import com.pocs.MarketProject.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserResponseMapper {

    public UserResponseDTO userToUserResponseDTO(User user){

        UserResponseDTO userResponseDTO = new UserResponseDTO();

        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setPhone(user.getPhone());
        userResponseDTO.setPassword(user.getPassword());

        return userResponseDTO;
    }

    public List<UserResponseDTO> userListToUserReponseDTO(List<User> userList){

        List<UserResponseDTO> userResponseList = new ArrayList<>();

        for(User user : userList){
            userResponseList.add(userToUserResponseDTO(user));
        }

        return userResponseList;
    }
}
