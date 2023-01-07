package com.example.iTrox.service.impl;

import com.example.iTrox.dto.UserResponseDto;
import com.example.iTrox.entity.User;
import com.example.iTrox.repository.UserRepository;
import com.example.iTrox.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;


    @Override
    public List<UserResponseDto> getAll() {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        List<User> users = repository.findAll();
        if(users != null){
            for(User user: users){
                UserResponseDto userResponseDto = new UserResponseDto();
                    userResponseDto.setId(user.getId());
                    userResponseDto.setName(user.getName());
                    userResponseDto.setGender(user.getGender());
                    userResponseDtos.add(userResponseDto);
                }
        }

        return userResponseDtos;

    }
}
