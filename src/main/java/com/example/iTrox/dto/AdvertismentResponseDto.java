package com.example.iTrox.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdvertismentResponseDto {

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;
}
