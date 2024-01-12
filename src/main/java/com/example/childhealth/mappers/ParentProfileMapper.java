package com.example.childhealth.mappers;

import com.example.childhealth.dto.ParentProfileDto;
import com.example.childhealth.entity.ParentProfileEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ParentProfileMapper {

    ParentProfileEntity dtoToEntity(ParentProfileDto dto);

    ParentProfileDto entityToDto(ParentProfileEntity entity);
}
