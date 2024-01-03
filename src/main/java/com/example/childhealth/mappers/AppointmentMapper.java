package com.example.childhealth.mappers;

import com.example.childhealth.dto.AppointmentDto;
import com.example.childhealth.entity.AppointmentEntity;
import org.mapstruct.Mapper;

@Mapper
public interface AppointmentMapper {

    AppointmentEntity dtoToEntity(AppointmentDto dto);

    AppointmentDto entityToDto(AppointmentEntity entity);
}
