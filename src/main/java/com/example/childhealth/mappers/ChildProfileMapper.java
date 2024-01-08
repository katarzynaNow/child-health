package com.example.childhealth.mappers;

import com.example.childhealth.dto.ChildProfileDto;
import com.example.childhealth.entity.ChildProfileEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ChildProfileMapper {

    ChildProfileEntity dtoToEntity(ChildProfileDto dto);

    ChildProfileDto entityToDto(ChildProfileEntity entity);
}

/*public class ChildProfileMapper {
    public static ChildProfileEntity dtoToEntity (ChildProfileDto model){
        ChildProfileEntity entity = new ChildProfileEntity();
        entity.setName(model.getName());
        entity.setBirthDate(model.getBirthDate());
        entity.setPicture(model.getPicture());

        return entity;
    }
}*/
