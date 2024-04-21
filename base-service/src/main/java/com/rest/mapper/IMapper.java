package com.rest.mapper;

import java.util.List;

public interface IMapper<DTO, Entity> {
    DTO toDTO(Entity entity);

    Entity toEntity(DTO dto);

    List<DTO> toDTOs(List<Entity> entities);

    List<Entity> toEntities(List<DTO> dtos);
}
