package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.group01.bits.entity.*;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
    @JsonProperty("userID")
    private Long userID;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("birthDay")
    private Date birthDay;
    @JsonProperty("email")
    private String email;
    @JsonProperty("major")
    private String major;
    @JsonProperty("role")
    private String role;
    @JsonProperty("image")
    private String image;
    @JsonProperty("schedules")
    private List<Schedule> schedules;
    @JsonProperty("availableTimes")
    private List<AvailableTime> availableTimes;
    @JsonProperty("qualifications")
    private List<Qualification> qualifications;
    @JsonProperty("subjects")
    private List<Subject> subjects;

}
