package com.example.iTrox.service;

import com.example.iTrox.dto.UserResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public List<UserResponseDto> getAll();
}
