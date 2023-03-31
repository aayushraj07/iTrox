package com.example.iTrox.service.impl;

import com.example.commons.exceptions.NotFoundException;
import com.example.iTrox.dto.UserRequestDto;
import com.example.iTrox.dto.UserResponseDto;
import com.example.iTrox.entity.Users;
import com.example.iTrox.repository.UserRepository;
import com.example.iTrox.service.UserService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    List<Users> users = repository.findAll();
    if (users != null) {
      for (Users user : users) {
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
    String nextUserId = null;
    String lastUsersId = repository.findByLastUSerId();

    if (lastUsersId != null) {
      nextUserId = nextUser(lastUsersId);
    } else {
      nextUserId = "usr01";
    }

    Users users = new Users();
    users.setUserId(nextUserId);
    users.setName(userRequestDto.getName());
    users.setAge(userRequestDto.getAge());
    users.setGender(userRequestDto.getGender());
    repository.save(users);
    return null;
  }

  public static String nextUser(String input) {
    // Create a regular expression that matches the number at the end of the input string
    String regex = "(\\d+)$";

    // Create a pattern object from the regular expression
    Pattern pattern = Pattern.compile(regex);

    // Create a matcher object to search for the pattern in the input string
    Matcher matcher = pattern.matcher(input);

    // Check if the pattern was found
    if (matcher.find()) {
      // Get the matched number as a string
      String numberStr = matcher.group(1);

      // Convert the number to an integer and increment it by 1
      int number = Integer.parseInt(numberStr);
      number++;

      // Create a new string with the incremented number and return it
      String newStr = input.substring(0, matcher.start(1)) + number;
      return newStr;
    }

    // If the pattern was not found, return the original input string
    return input;
  }

  @Override
  public UserResponseDto getById(UUID id) {
    Users users = repository.findById(id).orElseThrow(() -> new NotFoundException("No id found"));
    UserResponseDto userResponseDto = mapper.map(users, UserResponseDto.class);
    return userResponseDto;
  }
}
