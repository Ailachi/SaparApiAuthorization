package com.example.saparauthorization.errorHandling;

import com.example.saparauthorization.exception.ServiceFaultException;
import com.example.saparauthorization.exception.ValidationException;
import com.example.saparauthorization.util.Util;
import com.example.saparauthorization.viewModel.Status;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;


@ControllerAdvice("com.example.saparauthorization.controller")
public class GlobalExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

    @Override
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Status responseStatus = new Status(Util.VALIDATION_ERROR_CODE, Util.VALIDATION_ERROR_MESSAGE);
        ErrorData errorData = new ErrorData(responseStatus, ex.getLocalizedMessage());

        return ResponseEntity.ok(errorData);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorData> handleCustomValidationErrors(ValidationException ex, WebRequest webRequest) {
        return ResponseEntity.ok(ex.errorData);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<?> handleAuthorizationException(Exception ex) {
        System.out.println(ex.getMessage());
        return ResponseEntity.ok("AccessDeniedException ERROR");
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorData> handleBadCredentialsException(BadCredentialsException ex) {
        Status responseStatus = new Status(Util.BAD_CREDENTIALS_ERROR_CODE, Util.BAD_CREDENTIALS_ERROR_MESSAGE);
        ErrorData errorData = new ErrorData(responseStatus, ex.getLocalizedMessage());
        return ResponseEntity.ok(errorData);
    }


    @ExceptionHandler(ServiceFaultException.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Object> handleServiceFaultException(ServiceFaultException exception, WebRequest webRequest) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("error", exception.getErrorData());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Status", "500");
        return handleExceptionInternal(exception, body, httpHeaders, HttpStatus.BAD_REQUEST, webRequest);
    }
}
