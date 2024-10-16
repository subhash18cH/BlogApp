package com.subhash.devApp.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoResponse {

    private Integer id;

    private String userName;

    private String email;
}
