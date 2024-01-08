package com.example.childhealth.dto;

import com.example.childhealth.entity.DiseaseEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class AppointmentDto {

    private LocalDate date;

    @Size(min=2, max=30)
    private String diagnosis;

    @Size(min=2, max=30)
    private String medicines;

    private boolean antibiotic;

    @Size(max=200)
    private String notes;

    @NotNull
    private DiseaseEntity disease;

}
