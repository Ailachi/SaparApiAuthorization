package com.example.saparauthorization.exception;

import com.example.saparauthorization.errorHandling.ErrorData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceFaultException extends Exception {
    private ErrorData errorData;
}
