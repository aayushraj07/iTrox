package com.example.iTrox.service.impl;

import com.example.iTrox.dto.AdvertismentRequestDto;
import com.example.iTrox.dto.AdvertismentResponseDto;
import com.example.iTrox.entity.Advertisement;
import com.example.iTrox.repository.AdvertisementRepository;
import com.example.iTrox.service.AdvertisementService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

  private final AdvertisementRepository repository;

  @Override
  public List<AdvertismentResponseDto> getAll() {
    List<AdvertismentResponseDto> advertismentResponseDtos = new ArrayList<>();
    List<Advertisement> advertisements = repository.findAll();
    if (advertisements != null) {
      for (Advertisement advertisement : advertisements) {
        AdvertismentResponseDto advertismentResponseDto = new AdvertismentResponseDto();
        advertismentResponseDto.setTitle(advertisement.getTitle());
        advertismentResponseDto.setDescription(advertisement.getDescription());
        advertismentResponseDtos.add(advertismentResponseDto);
      }
    }
    return advertismentResponseDtos;
  }

  @Override
  public AdvertismentResponseDto create(AdvertismentRequestDto advertismentRequestDto) {
    Advertisement advertisement = new Advertisement();
    advertisement.setType(advertismentRequestDto.getType());
    advertisement.setDescription(advertismentRequestDto.getDescription());
    advertisement.setTitle(advertismentRequestDto.getTitle());
    repository.save(advertisement);
    return null;
  }
}
