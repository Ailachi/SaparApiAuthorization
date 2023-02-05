package com.example.saparauthorization.viewModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BasicResponse {
    private Status status;
    private BasicResponseData responseData;
}
