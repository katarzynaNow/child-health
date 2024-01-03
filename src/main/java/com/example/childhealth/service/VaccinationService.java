package com.example.childhealth.service;

import com.example.childhealth.entity.Vaccination;
import com.example.childhealth.repository.VaccinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VaccinationService {
    private final VaccinationRepository vaccinationRepository;

    public List<Vaccination> findAll() {

        return vaccinationRepository.findAll();
    }

    public Vaccination findById(UUID id){
        return vaccinationRepository.findById(id).get();
    }

    public void save(Vaccination vaccination){
        vaccinationRepository.save(vaccination);
    }

    public int howManyMandatoryVaccinations(UUID childId){
        List<Vaccination> vaccinations = vaccinationRepository.findByChildId(childId);
        int counter = 0;

        for (Vaccination v: vaccinations) {
            if (v.getScope().equals("mandatory") && v.getStatus().name().equals("DONE")){
                counter++;
            }
        }
        return counter;
    }

    public int howManyRecommendedVaccinations(UUID childId){
        List<Vaccination> vaccinations = vaccinationRepository.findByChildId(childId);
        int counter = 0;

        for (Vaccination v: vaccinations) {
            if (v.getScope().equals("recommended") && v.getStatus().name().equals("DONE")){
                counter++;
            }
        }
        return counter;
    }
}
