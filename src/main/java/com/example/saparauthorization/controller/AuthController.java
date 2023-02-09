package com.example.saparauthorization.controller;


import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.RegistrationModel;
import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.mappers.SaparMapper;
import com.example.saparauthorization.security.jwt.JwtUtils;
import com.example.saparauthorization.service.Users.JwtUserDetails;
import com.example.saparauthorization.service.authentication.AuthenticationService;
import com.example.saparauthorization.service.Users.UserService;
import com.example.saparauthorization.service.WebClientBuilder;

import com.example.saparauthorization.viewModel.Status;
import com.example.saparauthorization.viewModel.login.LoginResponseData;
import com.example.saparauthorization.viewModel.login.LoginResponseModel;
import com.example.saparauthorization.viewModel.registration.RegistrationResponseData;
import com.example.saparauthorization.viewModel.registration.RegistrationResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private WebClientBuilder webClientBuilder;
    private SaparMapper mapper;
    private AuthenticationService authenticationService;
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    public AuthController(SaparMapper mapper, AuthenticationService authenticationService, UserService userService) {

        this.mapper = mapper;
        this.authenticationService = authenticationService;
        this.userService = userService;

    }

    @PostMapping("/register")
    public RegistrationResponseModel register(@Valid @RequestBody RegistrationModel model) throws Exception {
        UserModel userModel = userService.create(model);
        return new RegistrationResponseModel(new RegistrationResponseData(userModel));
    }

    @PostMapping(value = "/login")
    public LoginResponseModel login(@Valid @RequestBody LoginModel model) throws Exception {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(model.getEmail(), model.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserModel user = userService.findUserByEmail(model.getEmail());
        LoginResponseData responseData = new LoginResponseData(user, jwt);
        return new LoginResponseModel(responseData);
    }


    @PostMapping(value = "/test")
    public String test(@RequestBody String testReq) {
        System.out.println("testRequest: " + testReq);
        String response = "";
        try {
            WebClient wc = webClientBuilder.getRestWebClient("localhost:8080/auth/test2");
            response = wc.post()
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .body(Mono.just(testReq + " RESPONSE!"), String.class)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
        } catch (Exception e) {
            //ELK.log("100", "login-rest-error", e.getMessage());
        }
        return response;
    }

    @GetMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test2() throws JsonProcessingException {
        return "Sa";
    }
}
