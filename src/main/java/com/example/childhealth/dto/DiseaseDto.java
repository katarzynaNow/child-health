package com.example.childhealth.dto;

import com.example.childhealth.entity.Symptom;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class DiseaseDto {

    @Size(min=2, max=30)
    private String name;

    private LocalDateTime startingDate;

    private LocalDateTime endingDate;

    private Symptom symptom1;

    private Symptom symptom2;

    private Symptom symptom3;
}
