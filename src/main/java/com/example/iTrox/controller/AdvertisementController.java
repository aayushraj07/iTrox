package com.example.iTrox.controller;

import com.example.commons.utils.Constants;
import com.example.iTrox.dto.AdvertismentResponseDto;
import com.example.iTrox.enums.Type;
import com.example.iTrox.service.AdvertisementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/advertisement")
@RequiredArgsConstructor
public class AdvertisementController {

  private final AdvertisementService advertisementService;

  @GetMapping
  public List<AdvertismentResponseDto> getAll() {
    return advertisementService.getAll();
  }

  @ResponseStatus(code = HttpStatus.CREATED)
  @ApiOperation(value = "Create a advertisement")
  @ApiResponses(
      value = {
        @ApiResponse(code = 201, message = Constants.SUCCESS),
        @ApiResponse(code = 401, message = Constants.UNAUTHORIZED_ACCESS),
        @ApiResponse(code = 403, message = Constants.ACCESS_FORBIDDEN),
        @ApiResponse(code = 400, message = Constants.BAD_REQUEST),
        @ApiResponse(code = 500, message = Constants.INTERNAL_SERVER_ERROR)
      })
  @PostMapping
  public AdvertismentResponseDto create(
      @RequestParam("title") String title,
      @RequestParam("description") String description,
      @RequestParam("type") Type type,
      @RequestParam("userId") String userId,
      @RequestParam("organisationId") String organisationId,
      @RequestPart("image") MultipartFile file)
      throws IOException {
    return advertisementService.create(title, description, type, userId, organisationId, file);
  }
}
