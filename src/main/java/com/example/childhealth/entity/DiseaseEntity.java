package com.example.childhealth.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name="diseases")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name="id")
    private UUID id;

    @NotNull
    @NotBlank
    @Size(max = 50)
    @Column(name="name", length = 50)
    private String name;

    @Column(name="starting_date")
    private LocalDateTime startingDate;

    @Column(name="ending_date")
    private LocalDateTime endingDate;

    @Enumerated(EnumType.STRING)
    @Column(name="symptom_1")
    private Symptom symptom1;//todo list of symptoms instead of 3

    @Enumerated(EnumType.STRING)
    @Column(name="symptom_2")
    private Symptom symptom2;

    @Enumerated(EnumType.STRING)
    @Column(name="symptom_3")
    private Symptom symptom3;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "child_id")
    private ChildProfileEntity child;

    /*@OneToMany(mappedBy = "disease", cascade = CascadeType.ALL)
    @Column(name="appointments")
    private List<AppointmentEntity> appointments;*/

}
