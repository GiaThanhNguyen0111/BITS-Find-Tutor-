package com.group01.bits.service;

import com.group01.bits.dto.DeleteTemplateDTO;
import com.group01.bits.dto.ReviewDTO;

import java.util.List;

public interface ReviewControlService {
    List<ReviewDTO> getReviewByTutorId(Long id);
    ReviewDTO postReview(ReviewDTO request);
    DeleteTemplateDTO deleteReviewById(Long id, String email);
}
