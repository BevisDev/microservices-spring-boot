package com.rest.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class Mapper<DTO, Entity> implements IMapper<DTO, Entity> {

    @Override
    public List<DTO> toDTOs(List<Entity> list) {
        List<DTO> dtos = new ArrayList<>();
        for (Entity item : list) {
            DTO dto = toDTO(item);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public List<Entity> toEntities(List<DTO> list) {
        List<Entity> entities = new ArrayList<>();
        for (DTO item : list) {
            Entity dto = toEntity(item);
            entities.add(dto);
        }
        return entities;
    }
    
}
