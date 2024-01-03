package com.example.childhealth.service;

import com.example.childhealth.entity.AppointmentEntity;
import com.example.childhealth.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public List<AppointmentEntity> findAll(){
        return appointmentRepository.findAll();
    }

 /*   public AppointmentEntity saveAppointmentModelToEntity(AppointmentDto appointmentModel){
        AppointmentEntity appointmentEntity = appointmentDtoToAppointmentEntity(appointmentModel);
        return appointmentRepository.save(appointmentEntity);
    }*/

    public void save (AppointmentEntity appointment){
        appointmentRepository.save(appointment);
    }

    public void deleteById(UUID id){
        appointmentRepository.deleteById(id);
    }

    public AppointmentEntity findById(UUID id){
        return appointmentRepository.findById(id).get();
    }

    public int howManyAntibiotics(UUID childId){
        List<AppointmentEntity> appointments = appointmentRepository.findByChildId(childId);
        int counter = 0;
        for ( AppointmentEntity a: appointments) {
            if (a.isAntibiotic() && a.getDate().getYear() == 2023){
                counter++;
            }
        }
        return counter;
    }
}
