package com.example.iTrox.dto;

import com.example.iTrox.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdvertismentRequestDto {

    private UUID id;

    private String title;

    private String description;

    private Type type;

}
