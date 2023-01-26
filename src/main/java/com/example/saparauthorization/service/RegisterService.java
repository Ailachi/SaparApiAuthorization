package com.example.saparauthorization.service;

import com.example.saparauthorization.viewModel.BasicResponse;
import com.example.saparauthorization.viewModel.RegisterRequest;

public interface RegisterService {
    BasicResponse handleRequest(RegisterRequest request);
}
