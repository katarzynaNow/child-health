package com.example.childhealth.service;

import com.example.childhealth.dto.ChildProfileDto;
import com.example.childhealth.entity.ChildProfileEntity;
import com.example.childhealth.entity.VacStatus;
import com.example.childhealth.entity.Vaccination;
import com.example.childhealth.mappers.ChildProfileMapper;
import com.example.childhealth.repository.ChildProfileRepository;
import com.example.childhealth.repository.VaccinationRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ChildProfileService {

    private final ChildProfileRepository childProfileRepository;
    private final VaccinationRepository vaccinationRepository;

    private final ChildProfileMapper childProfileMapper;

    public List<ChildProfileEntity> findAll() {

        return childProfileRepository.findAll();
    }

    public ChildProfileEntity findById(UUID id) {
        return childProfileRepository.findById(id).get();
    }

    public void deleteById(UUID id) {
        childProfileRepository.deleteById(id);
    }

   @Transactional
    public void saveChildProfileDtoToEntity(ChildProfileDto childProfileDto, MultipartFile file) throws IOException {
        childProfileDto.setPicture(file.getBytes());
        ChildProfileEntity entity = childProfileRepository.save(childProfileMapper.dtoToEntity(childProfileDto));
        List<Vaccination> list = new ArrayList<>();
        list.add(new Vaccination("mandatory", "Hepatitis B","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "BCG","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Pneumococci","0", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Rotavirus","2", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","2", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Pneumococci","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Rotavirus","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","4", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","5 - 6", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Rotavirus","5 - 6", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Hepatitis B","7", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","7", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "MMR","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "Pneumococci","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Meningococci","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Chickenpox","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "KZM","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("mandatory", "6in1","16 - 18", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Chickenpox","13 - 15", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Hepatitis A","24", VacStatus.TO_ARRANGE, "",  entity));
        list.add(new Vaccination("recommended", "Hepatitis A","30 - 36", VacStatus.TO_ARRANGE, "",  entity));

        vaccinationRepository.saveAll(list);
    }
}
