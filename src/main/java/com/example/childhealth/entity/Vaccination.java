package com.example.childhealth.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.UUID;

@Entity
@Table(name = "vaccinations")
@Getter
@Setter
@NoArgsConstructor
public class Vaccination {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name="id")
    private UUID id;

    @Column(name="scope")
    private String scope;

    @Column(name="name")
    private String name;

    private String childrenAgeInMonths;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private VacStatus status;

    @Column(name="notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private ChildProfileEntity child;

    public Vaccination(String scope, String name, String childrenAgeInMonths, VacStatus status, String notes, ChildProfileEntity child) {
        this.scope = scope;
        this.name = name;
        this.childrenAgeInMonths = childrenAgeInMonths;
        this.status = status;
        this.notes = notes;
        this.child = child;
    }
}
