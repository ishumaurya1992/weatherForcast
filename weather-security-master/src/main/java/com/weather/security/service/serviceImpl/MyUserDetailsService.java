package com.weather.security.service.serviceImpl;


import com.weather.security.exception.WeatherCustomException;
import com.weather.security.models.CustomUserDetails;
import com.weather.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        CustomUserDetails userDetails = userService.findByUserName(s);


        if (userDetails == null) { throw new WeatherCustomException("User Not Found",1002); }
        else { return new User(userDetails.getEmail(), userDetails.getPassword(),
                    new ArrayList<>()); }
    }
}