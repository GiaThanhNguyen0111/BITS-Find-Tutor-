package com.group01.bits.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private Long subjectID;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "subjects", fetch = FetchType.LAZY)
    private List<User> users;
}
