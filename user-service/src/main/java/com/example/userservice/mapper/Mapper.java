package com.example.userservice.mapper;

import java.util.List;
import java.util.stream.Collectors;

public interface Mapper<ENTITY extends IEntity, DTO extends ViewModel> {

    ENTITY toEntity(DTO dto);

    DTO toDto(ENTITY entity);

    default List<ENTITY> toEntities(List<DTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default List<DTO> toDtos(List<ENTITY> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }
}
