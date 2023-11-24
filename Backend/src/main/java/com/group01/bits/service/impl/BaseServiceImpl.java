package com.group01.bits.service.impl;

import com.group01.bits.constants.Role;
import com.group01.bits.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

@Service
@RequiredArgsConstructor
@Slf4j
public class BaseServiceImpl implements BaseService {
    @Override
    public boolean isStudent(String role) {
        return Role.STUDENT.equals(role);
    }

    @Override
    public boolean isTutor(String role) {
        return Role.STUDENT.equals(role);
    }

    @Override
    public boolean isAdmin(String role) {
        return Role.STUDENT.equals(role);
    }

    @Override
    public String extractToken(String authHeader) {
        return authHeader.substring(7);
    }
}
