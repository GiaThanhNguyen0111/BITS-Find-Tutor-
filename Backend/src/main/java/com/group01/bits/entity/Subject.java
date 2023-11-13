package com.group01.bits.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @Column(name = "subject_id")
    private Long subjectID;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "description")
    private String description;
}
