package com.example.iTrox.service.impl;

import com.example.commons.exceptions.NotFoundException;
import com.example.iTrox.dto.UserRequestDto;
import com.example.iTrox.dto.UserResponseDto;
import com.example.iTrox.entity.User;
import com.example.iTrox.repository.UserRepository;
import com.example.iTrox.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository repository;

  private final ModelMapper mapper;

  @Override
  public List<UserResponseDto> getAll() {
    List<UserResponseDto> userResponseDtos = new ArrayList<>();
    List<User> users = repository.findAll();
    if (users != null) {
      for (User user : users) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setName(user.getName());
        userResponseDto.setGender(user.getGender());
        userResponseDtos.add(userResponseDto);
      }
    }

    return userResponseDtos;
  }

  @Override
  public UserResponseDto create(UserRequestDto userRequestDto) {
    User user = new User();
    user.setUserId(userRequestDto.getUserId());
    user.setName(userRequestDto.getName());
    user.setAge(userRequestDto.getAge());
    user.setGender(userRequestDto.getGender());
    repository.save(user);
    return null;
  }

  @Override
  public UserResponseDto getById(UUID id) {
    User user = repository.findById(id).orElseThrow(() -> new NotFoundException("No id found"));

    UserResponseDto userResponseDto = mapper.map(user, UserResponseDto.class);
    return userResponseDto;
  }
}
