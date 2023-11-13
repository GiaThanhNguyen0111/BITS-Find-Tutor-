package com.group01.bits.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "qualification")
public class Qualification {
    @Id
    @Column(name = "qualification_id")
    private Long qualificationID;

    @Column(name = "qualification_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
