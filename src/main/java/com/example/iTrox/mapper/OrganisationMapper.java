package com.example.iTrox.mapper;

import com.example.iTrox.dto.OrganisationRequestDto;
import com.example.iTrox.dto.OrganisationResponseDto;
import com.example.iTrox.entity.Organisation;

public interface OrganisationMapper
    extends ModelMapperEntityToDto<Organisation, OrganisationResponseDto>,
        ModelMapperDtoToEntity<OrganisationRequestDto, Organisation> {}

// @Mapper(
//        componentModel = "spring",
//        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
//        unmappedTargetPolicy = ReportingPolicy.IGNORE)
// public interface OrganisationMapper
//        extends ModelMapperEntityToDto<Organisation, OrganisationResponseDto>,
//        ModelMapperDtoToEntity<OrganisationRequestDto, Organisation> {}
