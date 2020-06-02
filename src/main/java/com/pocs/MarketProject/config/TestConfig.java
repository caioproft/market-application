package com.pocs.MarketProject.config;

import com.pocs.MarketProject.domain.request.UserCreateRequest;
import com.pocs.MarketProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {

        UserCreateRequest userCreate1 = new UserCreateRequest("Caio", "caio@email.com", "9999", "caio");
        UserCreateRequest userCreate2 = new UserCreateRequest("Ariane", "ariane@email.com", "55555", "ariane");

        userService.createUser(userCreate1);
        userService.createUser(userCreate2);
    }
}
