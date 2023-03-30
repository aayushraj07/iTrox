package com.example.iTrox.service;

import com.example.iTrox.dto.OrganisationRequestDto;
import com.example.iTrox.dto.OrganisationResponseDto;
import java.util.List;

public interface OrganisationService {
  List<OrganisationResponseDto> getAll();

  OrganisationResponseDto create(OrganisationRequestDto organisationRequestDto);
}
