package com.example.chat.controller;


import com.example.chat.model.LoginResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @PostMapping
    public LoginResponse auth(@RequestHeader String username, @RequestHeader String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_FORM_URLENCODED));
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("client_id","chat_service");
        map.add("username",username);
        map.add("password",password);
        map.add("grant_type","password");
        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(
                "http://localhost:9090/auth/realms/master/protocol/openid-connect/token", entity, LoginResponse.class).getBody();
    }
}
