package com.example.iTrox.dto;


import com.example.iTrox.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDto {

    private UUID id;

    private String name;

    private Gender gender;
}
