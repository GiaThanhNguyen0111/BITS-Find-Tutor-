package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    @JsonProperty("scheduleID")
    private Long scheduleID;
    @JsonProperty("userID")
    private Long userID;
    @JsonProperty("startTime")
    private LocalDateTime startTime;
    @JsonProperty("endTime")
    private LocalDateTime endTime;
    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
}
