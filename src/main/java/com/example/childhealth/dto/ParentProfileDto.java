package com.example.childhealth.dto;

import jakarta.validation.constraints.Size;
import lombok.*;


@Builder
@Data
public class ParentProfileDto {

    @Size(max = 30)
    private String name;

    @Size(max = 30)
    private String surname;

}
