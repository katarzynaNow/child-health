package com.example.childhealth.mappers;

import com.example.childhealth.dto.DiseaseDto;
import com.example.childhealth.entity.DiseaseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DiseaseMapper {

    DiseaseEntity dtoToEntity(DiseaseDto dto);

    DiseaseDto entityToDto(DiseaseEntity entity);
}
