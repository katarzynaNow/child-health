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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="children_profiles")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChildProfileEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false, name = "id")
    private UUID id;

    @NotNull
    @NotBlank
    @Size(max = 30)
    @Column(length = 30, name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Lob
    @Column(name = "picture")
    private byte[] picture;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
    private List<DiseaseEntity> disease;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
    private List<AppointmentEntity> appointment;

    @OneToMany(mappedBy = "child", cascade = CascadeType.ALL)
    private List<Vaccination> vaccination;

    @ManyToOne
    @JoinColumn(name = "parent")
    private ParentProfileEntity parent;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
