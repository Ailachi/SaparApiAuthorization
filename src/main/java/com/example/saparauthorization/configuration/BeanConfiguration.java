package com.example.saparauthorization.configuration;

import com.example.saparauthorization.service.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.SpringVersion;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class BeanConfiguration {
//    @Bean
//    public IAuthenticationService AuthenticationService() {
//        return new AuthenticationService();
//    }

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder encoder;
    @Bean
    public void getPassword() {
        System.out.println(new BCryptPasswordEncoder().encode("anuar123_"));
    }

//    @Bean
//    public void test() {
//        userService.findAll().forEach(u -> System.out.println(u.getFirstName() + u.getRoleName()));
//        System.out.println(SpringVersion.getVersion());
//    }
}
