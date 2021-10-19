package com.weather.security.controller;

import com.weather.security.exception.WeatherCustomException;
import com.weather.security.models.AuthenticationRequest;
import com.weather.security.models.AuthenticationResponse;
import com.weather.security.models.CustomUserDetails;
import com.weather.security.service.UserService;
import com.weather.security.service.serviceImpl.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<?> test() {

        return ResponseEntity.ok("ok");
    }
    @CrossOrigin(origins = { "http://localhost:3000", "http://localhost:4200" })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest request) throws Exception {
        return ResponseEntity.ok(new AuthenticationResponse(userService.login(request)));
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody CustomUserDetails user) throws Exception {

        user.setPassword(Base64.getEncoder().encodeToString(user.getPassword().getBytes()));
        CustomUserDetails customUserDetails = null;
        try{
            customUserDetails = userService.save(user);
        }catch (WeatherCustomException e){
            throw new WeatherCustomException("User already exist.",1008);
        }
        return ResponseEntity.ok(customUserDetails);
    }



}


