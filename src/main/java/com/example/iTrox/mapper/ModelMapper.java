package com.example.iTrox.mapper;

public interface ModelMapper<E, D>
    extends ModelMapperEntityToDto<E, D>, ModelMapperDtoToEntity<D, E> {}
