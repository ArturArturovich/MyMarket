package com.geekbrains.artur.springMarket.service;


import com.geekbrains.artur.springMarket.persist.model.repo.ProductRepository;
import com.geekbrains.artur.springMarket.persist.model.repo.RoleRepository;
import com.geekbrains.artur.springMarket.persist.model.repo.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class ServiceConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository, RoleRepository roleRepository,
                        BCryptPasswordEncoder passwordEncoder){
        return new UserServiceJpaImpl(userRepository,roleRepository, passwordEncoder);

    }

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new ProductServiceImpl(productRepository);
    }
}
