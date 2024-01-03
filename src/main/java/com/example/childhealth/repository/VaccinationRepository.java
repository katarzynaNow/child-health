package com.example.childhealth.repository;

import com.example.childhealth.entity.Vaccination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VaccinationRepository extends JpaRepository<Vaccination, UUID> {

    List<Vaccination> findByChildId(UUID childId);
}
