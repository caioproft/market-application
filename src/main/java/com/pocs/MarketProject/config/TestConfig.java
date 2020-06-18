package com.pocs.MarketProject.config;

import com.pocs.MarketProject.domain.enuns.OrderStatus;
import com.pocs.MarketProject.domain.model.Category;
import com.pocs.MarketProject.domain.model.Order;
import com.pocs.MarketProject.domain.model.User;
import com.pocs.MarketProject.domain.request.OrderCreateRequest;
import com.pocs.MarketProject.domain.request.UserCreateRequest;
import com.pocs.MarketProject.mapper.UserMapper;
import com.pocs.MarketProject.repository.CategoryRepository;
import com.pocs.MarketProject.repository.OrderRepository;
import com.pocs.MarketProject.repository.UserRepository;
import com.pocs.MarketProject.service.OrderService;
import com.pocs.MarketProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.save(u1);
        userRepository.save(u2);


        Order o1 = new Order(null, LocalDateTime.now(), OrderStatus.WAITING_PAYMENT, u1);
        Order o2 = new Order(null, LocalDateTime.now(), OrderStatus.PAID, u2);
        Order o3 = new Order(null, LocalDateTime.now(), OrderStatus.DELIVERED, u1);

        orderRepository.save(o1);
        orderRepository.save(o2);
        orderRepository.save(o3);

    }
}
