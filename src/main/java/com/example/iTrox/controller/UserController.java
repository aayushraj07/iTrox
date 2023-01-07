package com.example.iTrox.controller;

import com.example.iTrox.dto.UserResponseDto;
import com.example.iTrox.repository.UserRepository;
import com.example.iTrox.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {


    private final UserRepository repository;

    private final UserService service;


    @GetMapping
    public List<UserResponseDto> getAllUSers(){
        return service.getAll();
    }
}
