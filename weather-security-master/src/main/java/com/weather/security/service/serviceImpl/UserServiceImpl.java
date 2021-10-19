package com.weather.security.service.serviceImpl;

import com.weather.security.exception.WeatherCustomException;
import com.weather.security.models.AuthenticationRequest;
import com.weather.security.models.AuthenticationResponse;
import com.weather.security.models.CustomUserDetails;
import com.weather.security.repository.UserReopsitory;
import com.weather.security.service.UserService;
import com.weather.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserReopsitory userReopsitory;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Override
    public CustomUserDetails save(CustomUserDetails user) {
        return userReopsitory.save(user);
    }

    @Override
    public CustomUserDetails findByUserName(String user) {
        return userReopsitory.findByEmail(user);
    }

    @Override
    public String login(AuthenticationRequest authenticationRequest) {

        CustomUserDetails customUserDetails= userReopsitory.findByEmail(authenticationRequest.getEmail());
        String jwt;
        if(customUserDetails.getPassword().equals(authenticationRequest.getPassword())
                && customUserDetails.getEmail().equals(authenticationRequest.getEmail())){
            jwt = jwtTokenUtil.generateToken(new User(authenticationRequest.getEmail(), authenticationRequest.getPassword(),
                    new ArrayList<>()));
            return jwt;
        }else{
            throw new WeatherCustomException("Incorrect username or password", 1000);
        }




    }


}
