package com.group01.bits.service.impl;

import com.group01.bits.dto.DeleteTemplateDTO;
import com.group01.bits.dto.ReviewDTO;
import com.group01.bits.entity.Review;
import com.group01.bits.entity.User;
import com.group01.bits.exception.BaseResponseException;
import com.group01.bits.repository.ReviewRepository;
import com.group01.bits.repository.UserRepository;
import com.group01.bits.service.ReviewControlService;
import com.group01.bits.template.ResponseStatusCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReviewControlServiceImpl implements ReviewControlService {

    private final ReviewRepository reviewRepository;

    private final UserRepository userRepository;

    @Override
    public List<ReviewDTO> getReviewByTutorId(Long id) {
        List<Review> reviews = reviewRepository.findAllByReceiverId(id).orElseThrow();
        List<ReviewDTO> dtos = new ArrayList<>();

        for (Review review: reviews) {
            ReviewDTO reviewDTO = ReviewDTO.builder()
                    .reviewID(review.getReviewID())
                    .content(review.getContent())
                    .receiverID(review.getReceiverID())
                    .senderID(review.getSenderID())
                    .updateAt(review.getUpdateAt())
                    .build();
            dtos.add(reviewDTO);
        }
        return dtos;
    }

    @Override
    public ReviewDTO postReview(ReviewDTO request) {
        Review review = Review.builder()
                .content(request.getContent())
                .reviewID(request.getReviewID())
                .receiverID(request.getReceiverID())
                .build();
        reviewRepository.save(review);
        return request;
    }

    @Override
    @Transactional
    public DeleteTemplateDTO deleteReviewById(Long id, String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        Long userId = user.getUserID();
        Optional<Review> optReview = reviewRepository.findById(id);
        Review review = optReview.get();
        DeleteTemplateDTO temp = DeleteTemplateDTO.builder().build();
        if (optReview.isPresent()) {
            if (review.getReceiverID() == userId || review.getSenderID() == userId) {
                reviewRepository.deleteById(id);
                temp.setNumberDeleted(1L);
                temp.setAcknowledgement(true);
            } else {
                throw new BaseResponseException(ResponseStatusCode.builder().code("09").httpCode(HttpStatusCode.valueOf(200)).build());
            }
        } else {
            temp.setNumberDeleted(0L);
            temp.setAcknowledgement(false);
            throw new BaseResponseException(ResponseStatusCode.builder().code("04").httpCode(HttpStatusCode.valueOf(200)).build());
        }
        return temp;
    }
}
