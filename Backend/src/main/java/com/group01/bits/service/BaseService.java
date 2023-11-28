package com.group01.bits.service;

import com.group01.bits.dto.SubjectDTO;

import java.util.List;

public interface BaseService {
    boolean isStudent(String role);
    boolean isTutor(String role);
    boolean isAdmin(String role);
    String extractToken(String authHeader);
    List<SubjectDTO> getAllSubjects();
}
