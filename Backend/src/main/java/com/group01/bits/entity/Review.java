package com.group01.bits.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @Column(name = "review_id")
    private Long reviewID;

    @Column(name = "content")
    private String content;

    @Column(name = "sender_id")
    private Long senderID;

    @Column(name = "receiver_id")
    private Long receiverID;

    @Column(name = "createAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;

    @Column(name = "updateAt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateAt;
}
