package com.pocs.MarketProject.mapper;

import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.domain.request.UserCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public User userCreateRequestToUser(UserCreateRequest userCreateRequest) {

        User user = new User();
        user.setName(userCreateRequest.getName());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(userCreateRequest.getPassword());
        user.setPhone(userCreateRequest.getPhone());

        return user;
    }
}
