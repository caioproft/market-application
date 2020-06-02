package com.pocs.MarketProject.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    private String name;
    private String email;
    private String phone;
    private String password;
}
