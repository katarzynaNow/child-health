package com.example.childhealth.mappers;

import com.example.childhealth.dto.DiseaseDto;
import com.example.childhealth.entity.DiseaseEntity;
import org.mapstruct.Mapper;

@Mapper
public interface DiseaseMapper {

    DiseaseEntity diseaseDtoToDiseaseEntity (DiseaseDto dto);

    DiseaseDto diseaseEntityToDiseaseDto (DiseaseEntity entity);
}
