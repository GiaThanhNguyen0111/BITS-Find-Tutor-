package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubjectDTO {
    @JsonProperty("subjectID")
    private Long subjectID;
    @JsonProperty("subjectName")
    private String subjectName;
    @JsonProperty("description")
    private String description;
}
