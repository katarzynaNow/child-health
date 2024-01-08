package com.example.childhealth.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ChildProfileDto {

    @Size(min=2, max=30)
    private String name;

    private LocalDate birthDate;

    private byte[] picture;

}
