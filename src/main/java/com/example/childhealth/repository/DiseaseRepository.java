package com.example.childhealth.repository;

import com.example.childhealth.entity.DiseaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface DiseaseRepository extends JpaRepository<DiseaseEntity, UUID> {

    List<DiseaseEntity> findByChildId(UUID childId);
}
