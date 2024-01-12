package com.example.childhealth.repository;

import com.example.childhealth.entity.ParentProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParentProfileRepository extends JpaRepository<ParentProfileEntity, UUID> {
}
