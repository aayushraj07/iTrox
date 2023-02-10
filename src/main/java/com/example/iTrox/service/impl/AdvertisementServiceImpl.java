package com.example.iTrox.service.impl;

import com.example.iTrox.dto.AdvertismentResponseDto;
import com.example.iTrox.entity.Advertisement;
import com.example.iTrox.repository.AdvertismentRepository;
import com.example.iTrox.service.AdvertisementService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AdvertisementServiceImpl implements AdvertisementService {

  private AdvertismentRepository repository;

  @Override
  public List<AdvertismentResponseDto> getAll() {

    List<AdvertismentResponseDto> advertismentResponseDtos = new ArrayList<>();
    List<Advertisement> advertisements1 = new ArrayList<>();
    advertisements1 = repository.findAll();
    for (Advertisement advertisement : advertisements1) {
      AdvertismentResponseDto advertismentResponseDto = new AdvertismentResponseDto();
      advertismentResponseDto.setTitle(advertisement.getTitle());
      advertismentResponseDto.setDescription(advertisement.getDescription());
      advertismentResponseDtos.add(advertismentResponseDto);
    }
    return advertismentResponseDtos;
  }
}
