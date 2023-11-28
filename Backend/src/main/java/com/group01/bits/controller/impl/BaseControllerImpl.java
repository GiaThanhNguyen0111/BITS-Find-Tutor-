package com.group01.bits.controller.impl;

import com.group01.bits.controller.BaseController;
import com.group01.bits.dto.SubjectDTO;
import com.group01.bits.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BaseControllerImpl implements BaseController {

    private final BaseService baseService;

    @Override
    public ResponseEntity<List<SubjectDTO>> getAllSubjects() {
        return ResponseEntity.ok(baseService.getAllSubjects());
    }
}
