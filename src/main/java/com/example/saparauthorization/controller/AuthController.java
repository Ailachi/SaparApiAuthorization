package com.example.saparauthorization.controller;


import com.example.saparauthorization.businessModel.LoginModel;
import com.example.saparauthorization.businessModel.RegistrationModel;
import com.example.saparauthorization.businessModel.UserModel;
import com.example.saparauthorization.mappers.SaparMapper;
import com.example.saparauthorization.model.User;
import com.example.saparauthorization.service.IAuthenticationService;


import com.example.saparauthorization.service.impl.AuthenticationService;
import com.example.saparauthorization.viewModel.login.LoginResponseData;
import com.example.saparauthorization.viewModel.login.LoginResponseModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.saparauthorization.service.WebClientBuilder;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private WebClientBuilder webClientBuilder;
    private SaparMapper mapper;
    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(SaparMapper mapper, AuthenticationService authenticationService) {

        this.mapper = mapper;
        this.authenticationService = authenticationService;

    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegistrationModel model) {

        return ResponseEntity.ok("Ok");
    }

    @PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoginResponseModel login(@RequestBody LoginModel model) throws Exception {
        UserModel user = authenticationService.login(model);
        LoginResponseModel responseModel = new LoginResponseModel(new LoginResponseData(user));
        return responseModel;
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

    @PostMapping(value = "/test2", produces = MediaType.APPLICATION_JSON_VALUE)
    public String test2(@RequestBody String testReq2) throws JsonProcessingException {
//        LoginResponseModel lg = new LoginResponseModel();
//        lg.setResponseData(new LoginResponseData());
//        lg.getResponseData().getUser().setEmail("gjgjfjkf");
//        String jsonNode = new ObjectMapper().writeValueAsString(lg);
        String jsonNode = new ObjectMapper().writeValueAsString(new UserModel());
        return jsonNode;
    }
}
