package com.group01.bits.controller.impl;

import com.group01.bits.appfilter.AppFilter;
import com.group01.bits.controller.ReviewManagementController;
import com.group01.bits.dto.DeleteTemplateDTO;
import com.group01.bits.dto.ReviewDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.service.BaseService;
import com.group01.bits.service.ReviewControlService;
import com.group01.bits.template.GeneralResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class ReviewManagementControllerImpl implements ReviewManagementController {

    private final ReviewControlService reviewControlService;

    private final BaseService baseService;

    private final AppFilter.JwtAdapter jwtAdapter;

    @Override
    public GeneralResponse<List<ReviewDTO>> getReviewByTutorId(UserDTO userDTO) {
        List<ReviewDTO> reviewDTOS = reviewControlService.getReviewByTutorId(userDTO.getUserID());
        return new GeneralResponse<>().success(reviewDTOS);
    }

    @Override
    public GeneralResponse<ReviewDTO> postReview(ReviewDTO request) {
        reviewControlService.postReview(request);
        return new GeneralResponse<>(request);
    }

    @Override
    public GeneralResponse<DeleteTemplateDTO> deleteReview(ReviewDTO request, String authorizeHeader) {
        String jwtToken = baseService.extractToken(authorizeHeader);
        String email = jwtAdapter.extractUsername(jwtToken);
        return new GeneralResponse<>().success(reviewControlService.deleteReviewById(request.getReviewID(), email));
    }
}
