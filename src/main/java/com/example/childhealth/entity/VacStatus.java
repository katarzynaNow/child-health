package com.example.childhealth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VacStatus {
    DONE ("done"),
    ARRANGED ("arranged"),
    TO_ARRANGE ("to arrange"),
    NOT_APPLICABLE("n/a");

    private String name;
}
