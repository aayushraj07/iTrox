package com.example.iTrox.service;

import com.example.iTrox.dto.AdvertismentRequestDto;
import com.example.iTrox.dto.AdvertismentResponseDto;
import java.util.List;

public interface AdvertisementService {
  List<AdvertismentResponseDto> getAll();

  AdvertismentResponseDto create(AdvertismentRequestDto advertismentRequestDto);
}
