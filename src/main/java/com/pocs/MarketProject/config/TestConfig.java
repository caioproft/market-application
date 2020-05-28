package com.pocs.MarketProject.config;

import com.pocs.MarketProject.domain.dto.UserDTO;
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

        UserDTO userDTO1 = new UserDTO("Caio", "caio@email.com", "9999", "caio");
        UserDTO userDTO2 = new UserDTO("Ariane", "ariane@email.com", "9999", "ariane");

        userService.create(userDTO1);
        userService.create(userDTO2);
    }
}
