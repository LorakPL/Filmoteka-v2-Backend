package com.filmoteka.v2.backend.controller;


import com.filmoteka.v2.backend.model.UserLoginRequest;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * this controller is made just for swagger for login endpoint provided by spring security
 */
@RestController
@RequestMapping("/")
@Api(value = "/", description = "fake login controller - real method provided by spring security")
public class FakeLoginController {

    @PostMapping("/login")
    public void fakeLogin(@RequestBody UserLoginRequest userLoginRequest) {
        throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
    }
}
