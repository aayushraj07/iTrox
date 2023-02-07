package com.example.iTrox.mapper;

public interface ModelMapperDtoToEntity<D, E> {

  E toEntity(D d);
}
