package com.group01.bits.controller;

import com.group01.bits.dto.QualificationDTO;
import com.group01.bits.dto.SubjectDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.entity.Qualification;
import com.group01.bits.entity.Subject;
import com.group01.bits.entity.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO
@RequestMapping("${api.general.path}")
public interface AccountManagementController {
    @GetMapping("getTutorByName")
    ResponseEntity<List<UserDTO>> getTutorByName(@RequestBody UserDTO request);

    @PostMapping("getTutorBySubject")
    ResponseEntity<List<UserDTO>> getTutorBySubject(@RequestBody SubjectDTO request);

    @GetMapping("getQualifications")
    ResponseEntity<QualificationDTO> getQualifications(@RequestBody UserDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @PostMapping("addSubjects")
    ResponseEntity<UserDTO> postAddSubjects(@RequestBody List<SubjectDTO> request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @PostMapping("addSchedule")
    ResponseEntity<UserDTO> postAddSchedule(@RequestBody UserDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @PostMapping("addQualification")
    ResponseEntity<UserDTO> postAddQualification(@RequestBody UserDTO request, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationString);

    @GetMapping("getAllUser")
    ResponseEntity<List<UserDTO>> getAllTutor();
}
