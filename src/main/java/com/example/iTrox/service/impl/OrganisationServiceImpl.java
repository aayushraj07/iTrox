package com.example.iTrox.service.impl;

import com.example.commons.exceptions.NotFoundException;
import com.example.iTrox.dto.OrganisationRequestDto;
import com.example.iTrox.dto.OrganisationResponseDto;
import com.example.iTrox.entity.Organisation;
import com.example.iTrox.repository.OrganisationRepository;
import com.example.iTrox.service.OrganisationService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

  private final OrganisationRepository repository;

  private final ModelMapper mapper;

  @Override
  public List<OrganisationResponseDto> getAll() {
    List<OrganisationResponseDto> organisationResponseDtos = new ArrayList<>();
    List<Organisation> organisations = repository.findAll();
    for (Organisation organisation : organisations) {
      OrganisationResponseDto organisationResponseDto = new OrganisationResponseDto();
      mapper.map(organisation, organisationResponseDto);
      organisationResponseDtos.add(organisationResponseDto);
    }
    return organisationResponseDtos;
  }

  @Override
  public OrganisationResponseDto create(OrganisationRequestDto organisationRequestDto) {
    String nextUserId = null;
    String lastUsersId = repository.findByLastUSerId();

    if (lastUsersId != null) {
      nextUserId = nextUser(lastUsersId);
    } else {
      nextUserId = "usr01";
    }
    organisationRequestDto.setOrganisationId(nextUserId);
    Organisation organisation = new Organisation();
    mapper.map(organisationRequestDto, organisation);
    repository.save(organisation);
    return null;
  }

  @Override
  public OrganisationResponseDto getById(UUID id) {
    Organisation organisation =
        repository.findById(id).orElseThrow(() -> new NotFoundException("No id Found"));
    OrganisationResponseDto organisationResponseDto =
        mapper.map(organisation, OrganisationResponseDto.class);
    return organisationResponseDto;
  }

  public static String nextUser(String input) {
    // Create a regular expression that matches the number at the end of the input string
    String regex = "(\\d+)$";

    // Create a pattern object from the regular expression
    Pattern pattern = Pattern.compile(regex);

    // Create a matcher object to search for the pattern in the input string
    Matcher matcher = pattern.matcher(input);

    // Check if the pattern was found
    if (matcher.find()) {
      // Get the matched number as a string
      String numberStr = matcher.group(1);

      // Convert the number to an integer and increment it by 1
      int number = Integer.parseInt(numberStr);
      number++;

      // Create a new string with the incremented number and return it
      String newStr = input.substring(0, matcher.start(1)) + number;
      return newStr;
    }
    // If the pattern was not found, return the original input string
    return input;
  }
}
