package com.group01.bits.controller;

import com.group01.bits.dto.SubjectDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("${api.general.path}")
public interface BaseController {
    @GetMapping("getAllSubjects")
    ResponseEntity<List<SubjectDTO>> getAllSubjects();
}
