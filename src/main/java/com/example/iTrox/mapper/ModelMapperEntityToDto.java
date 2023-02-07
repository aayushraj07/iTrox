package com.example.iTrox.mapper;

public interface ModelMapperEntityToDto<E, D> {

  D toDto(E e);
}
