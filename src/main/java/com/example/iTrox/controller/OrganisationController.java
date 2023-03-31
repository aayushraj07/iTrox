package com.example.iTrox.controller;

import com.example.commons.utils.Constants;
import com.example.iTrox.dto.OrganisationRequestDto;
import com.example.iTrox.dto.OrganisationResponseDto;
import com.example.iTrox.service.OrganisationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organisation")
@RequiredArgsConstructor
public class OrganisationController {

  private final OrganisationService service;

  @GetMapping
  public List<OrganisationResponseDto> getAllOrganisation() {
    return service.getAll();
  }

  @ResponseStatus(code = HttpStatus.CREATED)
  @ApiOperation(value = "Create a Organisation")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = Constants.SUCCESS),
        @ApiResponse(code = 401, message = Constants.UNAUTHORIZED_ACCESS),
        @ApiResponse(code = 403, message = Constants.ACCESS_FORBIDDEN),
        @ApiResponse(code = 400, message = Constants.BAD_REQUEST),
        @ApiResponse(code = 500, message = Constants.INTERNAL_SERVER_ERROR)
      })
  @PostMapping
  public OrganisationResponseDto create(
      @RequestBody OrganisationRequestDto organisationRequestDto) {
    return service.create(organisationRequestDto);
  }

  @GetMapping(value = "/{id}")
  public OrganisationResponseDto getById(@PathVariable UUID id) {
    return service.getById(id);
  }
}
