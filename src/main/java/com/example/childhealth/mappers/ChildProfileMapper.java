package com.example.childhealth.mappers;

import com.example.childhealth.dto.ChildProfileDto;
import com.example.childhealth.entity.ChildProfileEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ChildProfileMapper {

    ChildProfileEntity childProfileDtoToChildProfileEntity (ChildProfileDto dto);

    ChildProfileDto childProfileEntityToChildProfileDto (ChildProfileEntity entity);
}
