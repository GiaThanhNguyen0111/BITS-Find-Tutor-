package com.group01.bits.controller;

import com.group01.bits.dto.DeleteTemplateDTO;
import com.group01.bits.dto.ReviewDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.template.GeneralResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("${api.general.path}")
public interface ReviewManagementController {
    @GetMapping("getReview")
    GeneralResponse<List<ReviewDTO>> getReviewByTutorId(@RequestBody UserDTO userDTO);

    @PostMapping("postReview")
    GeneralResponse<ReviewDTO> postReview(@RequestBody ReviewDTO request);

    @DeleteMapping("deleteReview")
    GeneralResponse<DeleteTemplateDTO> deleteReview(@RequestBody ReviewDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);
}
