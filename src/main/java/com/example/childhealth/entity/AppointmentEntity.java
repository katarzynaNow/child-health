package com.example.childhealth.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="appointments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name = "id")
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "medicines")
    private String medicines;

    @Column(name = "antibiotic")
    private boolean antibiotic;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn
    private DiseaseEntity disease;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private ChildProfileEntity child;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
