package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.group01.bits.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualificationDTO {
    @JsonProperty("qualificationID")
    private Long qualificationID;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("expiryDate")
    private Date expiryDate;
    @JsonProperty("user")
    private User user;
}
