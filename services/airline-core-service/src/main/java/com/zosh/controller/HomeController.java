package com.zosh.controller;

import com.zosh.payload.response.ApiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public ApiResponse home(){
        return new ApiResponse("Welcome to Airline Core Service");
    }
}
