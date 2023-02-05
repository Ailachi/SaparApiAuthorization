package com.example.saparauthorization.log;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Log {
    private String source;
    private String destination;
    private String operation;
    private String processStatus;
    private String message;
    private String rqTm;
    private String errorText;
}
