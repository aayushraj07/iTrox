package com.example.iTrox.service;

import com.example.iTrox.dto.AdvertismentResponseDto;
import com.example.iTrox.enums.Type;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface AdvertisementService {
  List<AdvertismentResponseDto> getAll();

  AdvertismentResponseDto create(
      String title,
      String description,
      Type type,
      String userId,
      String organisationId,
      MultipartFile file)
      throws IOException;
}
