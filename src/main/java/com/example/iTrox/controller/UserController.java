package com.example.iTrox.controller;

import com.example.commons.utils.Constants;
import com.example.iTrox.dto.UserRequestDto;
import com.example.iTrox.dto.UserResponseDto;
import com.example.iTrox.repository.UserRepository;
import com.example.iTrox.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository repository;

  private final UserService service;

  @GetMapping
  public List<UserResponseDto> getAllUSers() {
    return service.getAll();
  }

  @ResponseStatus(code = HttpStatus.CREATED)
  @ApiOperation(value = "Create a Assessment Practical Checklist")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = Constants.SUCCESS),
        @ApiResponse(code = 401, message = Constants.UNAUTHORIZED_ACCESS),
        @ApiResponse(code = 403, message = Constants.ACCESS_FORBIDDEN),
        @ApiResponse(code = 400, message = Constants.BAD_REQUEST),
        @ApiResponse(code = 500, message = Constants.INTERNAL_SERVER_ERROR)
      })
  @PostMapping
  public UserResponseDto create(@RequestBody UserRequestDto userRequestDto) {
    return service.create(userRequestDto);
  }

  @GetMapping(value = "/{id}")
  public UserResponseDto getById(@PathVariable UUID id) {
    return service.getById(id);
  }
}
