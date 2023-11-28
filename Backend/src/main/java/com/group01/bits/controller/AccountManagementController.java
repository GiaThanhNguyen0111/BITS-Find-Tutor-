package com.group01.bits.controller;

import com.group01.bits.dto.AvailableTimeDTO;
import com.group01.bits.dto.QualificationDTO;
import com.group01.bits.dto.SubjectDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.entity.AvailableTime;
import com.group01.bits.template.GeneralResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO
@RequestMapping("${api.general.path}")
public interface AccountManagementController {
    @GetMapping("getTutorByName")
    GeneralResponse<List<UserDTO>> getTutorByName(@RequestBody UserDTO request);

    @PostMapping("getTutorBySubject")
    GeneralResponse<List<UserDTO>> getTutorBySubject(@RequestBody SubjectDTO request);

    @GetMapping("getQualifications")
    GeneralResponse<List<QualificationDTO>> getQualifications(@RequestBody UserDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @PostMapping("addSubjects")
    GeneralResponse<UserDTO> postAddSubjects(@RequestBody List<SubjectDTO> request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @PostMapping("addSchedule")
    GeneralResponse<UserDTO> postAddSchedule(@RequestBody UserDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @PostMapping("addQualification")
    GeneralResponse<UserDTO> postAddQualification(@RequestBody UserDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @PostMapping("addAvailableTime")
    GeneralResponse<List<AvailableTime>> postAddAvailableTime(@RequestBody AvailableTimeDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @GetMapping("getAllUser")
    GeneralResponse<List<UserDTO>> getAllTutor();

    interface BaseController {

    }
}
