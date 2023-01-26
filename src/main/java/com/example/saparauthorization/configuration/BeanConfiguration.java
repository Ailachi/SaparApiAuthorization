package com.example.saparauthorization.configuration;

import com.example.saparauthorization.mappers.SaparMapper;
import com.example.saparauthorization.service.IAuthenticationService;
import com.example.saparauthorization.service.impl.AuthenticationService;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public IAuthenticationService AuthenticationService() {
        return new AuthenticationService();
    }
}
