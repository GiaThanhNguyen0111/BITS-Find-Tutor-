package com.group01.bits.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    @JsonProperty("reviewID")
    private Long reviewID;
    @JsonProperty("content")
    private String content;
    @JsonProperty("senderID")
    private Long senderID;
    @JsonProperty("receiverID")
    private Long receiverID;
    @JsonProperty("createAt")
    private Date createAt;
    @JsonProperty("updateAt")
    private Date updateAt;
}
