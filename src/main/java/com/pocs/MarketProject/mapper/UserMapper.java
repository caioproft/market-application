package com.pocs.MarketProject.mapper;

import com.pocs.MarketProject.domain.dto.UserDTO;
import com.pocs.MarketProject.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User UserDTOToUser(UserDTO userDTO){

        User user = new User();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhone(userDTO.getPhone());
        user.setPassword(userDTO.getPassword());

        return user;
    }
}
