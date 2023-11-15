package com.group01.bits.controller;

import com.group01.bits.dto.AuthenticationRequestDTO;
import com.group01.bits.dto.AuthenticationResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/auth/")
public interface AccountManagementController {
    @PostMapping("register")
    ResponseEntity<AuthenticationResponseDTO> postRegister(@RequestBody AuthenticationRequestDTO request);

    @PostMapping("authenticate")
    ResponseEntity<AuthenticationResponseDTO> postAuthenticate(@RequestBody AuthenticationRequestDTO request);
}