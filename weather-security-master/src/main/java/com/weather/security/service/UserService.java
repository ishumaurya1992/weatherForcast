package com.weather.security.service;


import com.weather.security.models.AuthenticationRequest;
import com.weather.security.models.AuthenticationResponse;
import com.weather.security.models.CustomUserDetails;

public interface UserService {
    CustomUserDetails save(CustomUserDetails user);

    CustomUserDetails findByUserName(String user);

    String login(AuthenticationRequest user);

}
