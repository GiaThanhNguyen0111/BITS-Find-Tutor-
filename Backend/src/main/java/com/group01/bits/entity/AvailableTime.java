package com.group01.bits.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "available_time")
public class AvailableTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "available_time_id")
    private Long id;

    @JsonFormat(pattern = "EEE, HH:mm:ss")
    @Column(name = "start_time")
    private Date startTime;

    @JsonFormat(pattern = "EEE, HH:mm:ss")
    @Column(name = "end_time")
    private Date endTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
