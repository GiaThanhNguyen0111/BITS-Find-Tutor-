package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.group01.bits.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AvailableTimeDTO {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("abbreviationDay")
    private String abbreviationDay;
    @JsonFormat(pattern = "HH:mm:ss")
    @JsonProperty("startTime")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    @JsonProperty("endTime")
    private Date endTime;
}
