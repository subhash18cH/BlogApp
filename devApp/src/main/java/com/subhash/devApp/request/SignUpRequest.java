package com.subhash.devApp.request;

import lombok.Data;

@Data
public class SignUpRequest {

    private String userName;

    private String password;

    private String email;
}
