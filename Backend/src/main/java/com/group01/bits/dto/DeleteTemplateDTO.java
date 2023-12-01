package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class DeleteTemplateDTO {
    @JsonProperty("acknowledgement")
    private boolean acknowledgement;
    @JsonProperty("numberDeleted")
    private Long numberDeleted;

}
