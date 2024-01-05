package com.example.childhealth.bootstrap;

import com.example.childhealth.entity.VacStatus;
import com.example.childhealth.entity.Vaccination;
import com.example.childhealth.repository.VaccinationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private final VaccinationRepository vaccinationRepository;

    @Override
    public void run(String... args) throws Exception {
        loadVaccinationData();
    }

    private void loadVaccinationData(){
        if(vaccinationRepository.count() == 0) {
            List<Vaccination> list = new ArrayList<>();
            list.add(new Vaccination("mandatory", "Hepatitis B","0", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "BCG","0", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "6in1","0", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "Pneumococci","0", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "Rotavirus","2", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Meningococci","2", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "6in1","4", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "Pneumococci","4", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "Rotavirus","4", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Meningococci","4", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "6in1","5 - 6", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "Rotavirus","5 - 6", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "Hepatitis B","7", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Meningococci","7", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "MMR","13 - 15", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "Pneumococci","13 - 15", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Meningococci","13 - 15", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Chickenpox","13 - 15", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "KZM","13 - 15", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("mandatory", "6in1","16 - 18", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Chickenpox","13 - 15", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Hepatitis A","24", VacStatus.TO_ARRANGE, ""));
            list.add(new Vaccination("recommended", "Hepatitis A","30 - 36", VacStatus.TO_ARRANGE, ""));

            vaccinationRepository.saveAll(list);
        }
    }
}
