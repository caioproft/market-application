package com.pocs.MarketProject.config;

import com.pocs.MarketProject.domain.dto.UserRequestDTO;
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

        UserRequestDTO userRequestDTO1 = new UserRequestDTO("Caio", "caio@email.com", "9999", "caio");
        UserRequestDTO userRequestDTO2 = new UserRequestDTO("Ariane", "ariane@email.com", "55555", "ariane");

        userService.create(userRequestDTO1);
        userService.create(userRequestDTO2);
    }
}
