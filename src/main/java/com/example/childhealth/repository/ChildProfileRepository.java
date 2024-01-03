package com.example.childhealth.repository;

import com.example.childhealth.entity.ChildProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChildProfileRepository extends JpaRepository<ChildProfileEntity, UUID> {
}
