package com.example.saparauthorization.controller;

import com.example.saparauthorization.errorHandling.ErrorData;
import com.example.saparauthorization.errorHandling.ServiceFaultException;
import com.example.saparauthorization.service.RegisterService;
import com.example.saparauthorization.service.WebClientBuilder;
import com.example.saparauthorization.util.Util;
import com.example.saparauthorization.viewModel.BasicResponse;
import com.example.saparauthorization.viewModel.RegisterRequest;
import com.example.saparauthorization.viewModel.RegisterResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    WebClientBuilder webClientBuilder;
    @Autowired
    RegisterService registerService;

    @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BasicResponse> register(@RequestBody RegisterRequest request) throws ServiceFaultException {
        try {

        } catch (Exception e) {
//            ELKLogger.log()
            throw new ServiceFaultException(new ErrorData(Util.ERROR_CODE, Util.ERROR_MESSAGE, e.getMessage()));
        }
        return ResponseEntity.ok(new BasicResponse());
    }





//    @PostMapping(value = "/test")
//    public String test(@RequestBody String testReq) {
//        System.out.println("testRequest: " + testReq);
//        String response = "";
//        try {
//            WebClient wc = webClientBuilder.getRestWebClient("localhost:8080/auth/test2");
//            response = wc.post()
//                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                    .body(Mono.just(testReq + " RESPONSE!"), String.class)
//                    .retrieve()
//                    .bodyToMono(String.class)
//                    .block();
//        } catch (Exception e) {
//            ELK.log("100", "login-rest-error", e.getMessage());
//        }
//        return response;
//    }
//
//    @PostMapping(value = "/test2")
//    public String test2(@RequestBody String testReq2) {
//        System.out.println(testReq2);
//        return testReq2;
//    }
}
