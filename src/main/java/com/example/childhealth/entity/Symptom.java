package com.example.childhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Symptom {
    CHILLS ("chills"),
    COUGH ("cough"),
    DIARRHEA ("diarrhea"),
    EAR_ACHE ("ear ache"),
    FEVER ("fever"),
    RASH ("rash"),
    RUNNY_NOSE ("runny nose"),
    SORE_THROAT ("sore throat"),
    STOMACHACHE ("stomachache"),
    VOMITING ("vomiting");

    private String name;
}
