package com.pocs.MarketProject.mapper;

import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.domain.request.UserCreateRequest;
import com.pocs.MarketProject.domain.request.UserUpdateRequest;
import com.pocs.MarketProject.domain.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {


    public UserResponse userToUserResponse(User user){

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .build();
    }

    public User userCreateRequestToUser(UserCreateRequest userCreateRequest) {

        User user = new User();
        user.setName(userCreateRequest.getName());
        user.setEmail(userCreateRequest.getEmail());
        user.setPassword(userCreateRequest.getPassword());
        user.setPhone(userCreateRequest.getPhone());

        return user;
    }

    public User userUpdateRequestToUser(User user, UserUpdateRequest userUpdateRequest){

        user.setName(userUpdateRequest.getName());
        user.setEmail(userUpdateRequest.getEmail());
        user.setPhone(userUpdateRequest.getPhone());

        return user;
    }

}
