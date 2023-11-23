package com.group01.bits.service;

public interface BaseService {
    boolean isStudent(String role);
    boolean isTutor(String role);
    boolean isAdmin(String role);

    String extractToken(String authHeader);
}
