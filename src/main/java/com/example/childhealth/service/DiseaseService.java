package com.example.childhealth.service;

import com.example.childhealth.entity.DiseaseEntity;
import com.example.childhealth.dto.DiseaseDto;
import com.example.childhealth.mappers.DiseaseMapper;
import com.example.childhealth.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiseaseService {

    private final DiseaseRepository diseaseRepository;
    private final DiseaseMapper diseaseMapper;


    public List<DiseaseEntity> findAll() {
        return diseaseRepository.findAll();
    }

    public DiseaseEntity saveDiseaseModelToEntity(DiseaseDto diseaseModel){
        DiseaseEntity diseaseEntity = diseaseMapper.dtoToEntity(diseaseModel);

        return diseaseRepository.save(diseaseEntity);
    }

    public void save (DiseaseEntity disease){
        diseaseRepository.save(disease);
    }

    public void deleteById(UUID id){
        diseaseRepository.deleteById(id);
    }

    public DiseaseEntity findById(UUID id){
        return diseaseRepository.findById(id).get();
    }

    public int[] daysInMonthsSick(UUID childId){
        List<DiseaseEntity> diseases = diseaseRepository.findByChildId(childId);
        int[] sickDaysEveryMonth = new int[12];

        for (int i = 1; i < 13; i++) {
            for (DiseaseEntity d : diseases) {

                int startDay = d.getStartingDate().getDayOfMonth();
                int endDay = d.getEndingDate().getDayOfMonth();
                int startMonth = d.getStartingDate().getMonthValue();
                int endMonth = d.getEndingDate().getMonthValue();

                int diseaseDuration = 0;

                if( d.getStartingDate().getYear() == 2023 && d.getEndingDate().getYear() == 2023 ) {
                    if (startMonth == i && endMonth == i) {
                        diseaseDuration = endDay - startDay;
                    } else if (startMonth == i && (i == 4 || i == 6 || i == 9 || i == 11)) {
                        diseaseDuration = 30 - startDay;
                    } else if (startMonth == i && i == 2) {
                        diseaseDuration = 28 - startDay;
                    } else if (startMonth == i) {
                        diseaseDuration = 31 - startDay;
                    } else if (endMonth == i) {
                        diseaseDuration = endDay;
                    }
                    sickDaysEveryMonth[i - 1] += diseaseDuration;
                }
            }
        }
        return sickDaysEveryMonth;
    }

    public int sickDaysInYear(int[] daysInMonthsSick ){
        int sickDaysInYear = 0;

        for (int j : daysInMonthsSick) {
            sickDaysInYear += j;
        }
        return sickDaysInYear;
    }

    public int sickDaysPercentage(int sickDaysInYear){
        int dayOfYear = LocalDate.now().getDayOfYear();
        return (sickDaysInYear * 100)/dayOfYear;
    }

    public List<UUID> diseasesIdList(UUID profileId) {
        List<DiseaseEntity> diseases = diseaseRepository.findByChildId(profileId);
        List<UUID> diseasesId = new ArrayList<>();

        for (DiseaseEntity d : diseases) {
            diseasesId.add(d.getId());
        }
        return diseasesId;
    }
}
