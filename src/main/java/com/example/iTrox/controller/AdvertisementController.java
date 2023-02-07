package com.example.iTrox.controller;

import com.example.iTrox.dto.AdvertismentResponseDto;
import com.example.iTrox.service.AdvertisementService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdvertisementController {

  private final AdvertisementService advertisementService;

  @GetMapping
  public List<AdvertismentResponseDto> getAll() {
    return advertisementService.getAll();
  }
}
