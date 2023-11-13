package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionHistoryDTO {
   @JsonProperty("transID")
    private Long transID;
    @JsonProperty("createAt")
    private Date createAt;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("senderID")
    private Long senderID;
    @JsonProperty("receiverID")
    private Long receiverID;
}
