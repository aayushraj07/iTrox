package com.example.iTrox.dto;

import com.example.iTrox.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {

  private String userId;
  private String name;
  private Long age;
  private Gender gender;
  private String email;
}
