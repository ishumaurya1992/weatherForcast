package com.application.weatherForcast.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class UserInterceptor extends OncePerRequestFilter {
    @Autowired
    RestTemplate restTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", httpServletRequest.getHeader("Authorization").split(",")[0]);
        String url = "http://localhost:8081/test";
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpStatus response = null;
        try{
            response  = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getStatusCode();
        }catch(Exception e){
        }

        if (response == null ) {
            ((HttpServletResponse) httpServletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "The token is not valid.");
        } else {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }
}

