package com.example.childhealth.mappers;

import com.example.childhealth.dto.ChildProfileDto;
import com.example.childhealth.entity.ChildProfileEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ChildProfileMapper {

    ChildProfileEntity dtoToEntity(ChildProfileDto dto);

    ChildProfileDto entityToDto(ChildProfileEntity entity);
}
