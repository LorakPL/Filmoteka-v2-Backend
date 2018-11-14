package com.filmoteka.v2.backend.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginRequest {

    @NotNull(message = "Username is required.")
    private String username;

    @NotNull(message = "Password is required")
    private String password;


}
