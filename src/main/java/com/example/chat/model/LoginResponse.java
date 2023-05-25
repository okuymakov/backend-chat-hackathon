package com.example.chat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    @JsonProperty("access_token")
    private String token;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("token_type")
    private String tokenType;
}
