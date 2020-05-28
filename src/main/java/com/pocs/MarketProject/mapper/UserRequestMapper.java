package com.pocs.MarketProject.mapper;

import com.pocs.MarketProject.domain.dto.UserRequestDTO;
import com.pocs.MarketProject.domain.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRequestMapper {

    public User UserDTOToUser(UserRequestDTO userRequestDTO){

        User user = new User();

        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setPhone(userRequestDTO.getPhone());
        user.setPassword(userRequestDTO.getPassword());

        return user;
    }


}
