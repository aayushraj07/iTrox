package com.example.iTrox.dto;

import com.example.iTrox.enums.Type;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationRequestDto {
  private String name;

  private String organisationId;

  private String email;

  private Type type;
}
