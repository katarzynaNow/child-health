package com.example.childhealth.mappers;

import com.example.childhealth.dto.AppointmentDto;
import com.example.childhealth.entity.AppointmentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentMapper {

    AppointmentEntity dtoToEntity(AppointmentDto dto);

    AppointmentDto entityToDto(AppointmentEntity entity);
}

/*public class AppointmentMapper {
    public static AppointmentEntity dtoToEntity(AppointmentDto model){
        AppointmentEntity entity = new AppointmentEntity();
        entity.setDate(model.getDate());
        entity.setDiagnosis(model.getDiagnosis());
        entity.setMedicines(model.getMedicines());
        entity.setAntibiotic(model.isAntibiotic());
        entity.setNotes(model.getNotes());
        entity.setDisease(model.getDisease());

        return entity;
    }
}*/
