package com.group01.bits.service;

import com.group01.bits.dto.AuthenticationRequestDTO;
import com.group01.bits.dto.AuthenticationResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    AuthenticationResponseDTO register(AuthenticationRequestDTO request) throws Exception;
    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response);
}