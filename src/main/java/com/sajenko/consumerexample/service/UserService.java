package com.sajenko.consumerexample.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class UserService {

    int port = 8081;

    public List<User> getAllUsers() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        RestTemplate rest = new RestTemplate();
        rest.setMessageConverters(Collections.singletonList(converter));
        ResponseEntity<User[]> exchange = rest.getForEntity(
                "http://localhost:" + port + "/users",
                User[].class);
        return Arrays.asList(exchange.getBody());
    }

    public ResponseEntity<User> getUser(@PathVariable Long id) {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        RestTemplate rest = new RestTemplate();
        rest.setMessageConverters(Collections.singletonList(converter));
        return rest.getForEntity(
                "http://localhost:" + port + "/users/" + id,
                User.class);
    }
}
