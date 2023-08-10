package com.sajenko.consumerexample.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerPort;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureStubRunner(ids = "com.sajenko:producerexample:+:stubs", stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class UserServiceIntegrationTest {

    @StubRunnerPort("com.sajenko:producerexample")
    private int port;

    @Autowired
    private UserService userService;

    @BeforeEach
    void setUp() {
        this.userService.port = port;
    }

    @Test
    void shouldReturnAllUsers() {
    }

    @Test
    void shouldReturnUser() {
    }

    @Test
    void shouldReturnNoContent() {
    }

}
