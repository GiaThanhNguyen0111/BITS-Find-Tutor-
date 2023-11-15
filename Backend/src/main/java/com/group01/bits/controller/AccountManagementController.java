package com.group01.bits.controller;

import com.group01.bits.dto.QualificationDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.entity.Qualification;
import com.group01.bits.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO
@RequestMapping("${api.general.path}")
public interface AccountManagementController {
    @GetMapping("getTutorByName")
    ResponseEntity<UserDTO> getTutorByName(@RequestBody UserDTO request);

    @GetMapping("getTutorBySubject")
    ResponseEntity<UserDTO> getTutorBySubject(@RequestBody UserDTO request);

    @GetMapping("getQualifications")
    ResponseEntity<QualificationDTO> getQualifications(@RequestBody UserDTO request);
}
