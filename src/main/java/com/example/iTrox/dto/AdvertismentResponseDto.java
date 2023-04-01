package com.example.iTrox.dto;

import com.example.iTrox.enums.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertismentResponseDto {

  private String title;

  private String description;

  private String email;

  private Type type;

  private String userId;

  private String organisationId;

  private String downloadUrl;
}
