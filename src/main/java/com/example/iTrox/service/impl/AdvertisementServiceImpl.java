package com.example.iTrox.service.impl;

import com.example.commons.utils.ImageUtil;
import com.example.iTrox.dto.AdvertismentResponseDto;
import com.example.iTrox.entity.Advertisement;
import com.example.iTrox.enums.Type;
import com.example.iTrox.repository.AdvertisementRepository;
import com.example.iTrox.service.AdvertisementService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class AdvertisementServiceImpl implements AdvertisementService {

  private final AdvertisementRepository repository;

  private final ModelMapper mapper;

  @Override
  public List<AdvertismentResponseDto> getAll() {
    List<AdvertismentResponseDto> advertismentResponseDtos = new ArrayList<>();
    List<Advertisement> advertisements = repository.findAll();
    if (advertisements != null) {
      for (Advertisement advertisement : advertisements) {
        AdvertismentResponseDto advertismentResponseDto = new AdvertismentResponseDto();
        advertismentResponseDto.setTitle(advertisement.getTitle());
        advertismentResponseDto.setDescription(advertisement.getDescription());
        //        advertismentResponseDto.setImageData(
        //            ImageUtil.decompressImage(advertisement.getImageData()));
        advertismentResponseDto.setEmail(advertisement.getEmail());
        if (advertisement.getType().equals(Type.PERSONAL)) {
          advertismentResponseDto.setUserId(advertisement.getUserId());
        } else if (advertisement.getType().equals(Type.COMMERCIAL)) {
          advertismentResponseDto.setOrganisationId(advertisement.getOrganisationId());
        }
        advertismentResponseDtos.add(advertismentResponseDto);
      }
    }
    return advertismentResponseDtos;
  }

  @Override
  public AdvertismentResponseDto create(
      String title,
      String description,
      Type type,
      String userId,
      String organisationId,
      MultipartFile file)
      throws IOException {
    Advertisement advertisement = new Advertisement();
    AdvertismentResponseDto advertismentResponseDto = new AdvertismentResponseDto();

    if (type.equals(Type.PERSONAL)) {
      advertisement.setUserId(userId);
    } else if (type.equals(Type.COMMERCIAL)) {
      advertisement.setOrganisationId(organisationId);
    }
    advertisement.setType(type);
    advertisement.setDescription(description);
    advertisement.setTitle(title);
    advertisement.setImageData(ImageUtil.compressImage(file.getBytes()));
    repository.save(advertisement);

    String downloadURl = "";
    downloadURl =
        ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/download/")
            .path(String.valueOf(advertisement.getId()))
            .toUriString();
    advertismentResponseDto.setDownloadUrl(downloadURl);
    mapper.map(advertisement, advertismentResponseDto);
    return advertismentResponseDto;
  }
}
