package com.example.iTrox.service;

import com.example.iTrox.dto.UserRequestDto;
import com.example.iTrox.dto.UserResponseDto;
import java.util.List;
import java.util.UUID;

public interface UserService {
  public List<UserResponseDto> getAll();

  UserResponseDto create(UserRequestDto userRequestDto);

  UserResponseDto getById(UUID id);
}
