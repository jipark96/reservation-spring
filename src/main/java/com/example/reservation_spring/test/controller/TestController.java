package com.example.reservation_spring.test.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class TestController {

    @GetMapping("hello")
    public List<String> hello() {
        return Arrays.asList("hello", "world");
    }
}
