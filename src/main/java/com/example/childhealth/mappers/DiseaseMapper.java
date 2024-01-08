package com.example.childhealth.mappers;

import com.example.childhealth.dto.DiseaseDto;
import com.example.childhealth.entity.DiseaseEntity;
import org.mapstruct.Mapper;


@Mapper
public interface DiseaseMapper {

    DiseaseEntity dtoToEntity(DiseaseDto dto);

    DiseaseDto entityToDto(DiseaseEntity entity);
}


/*public class DiseaseMapper {
    public static DiseaseEntity dtoToEntity(DiseaseDto model){
        DiseaseEntity entity = new DiseaseEntity();
        entity.setName(model.getName());
        entity.setStartingDate(model.getStartingDate());
        entity.setEndingDate(model.getEndingDate());
        entity.setSymptom1(model.getSymptom1());
        entity.setSymptom2(model.getSymptom2());
        entity.setSymptom3(model.getSymptom3());

        return entity;
    }
}*/
