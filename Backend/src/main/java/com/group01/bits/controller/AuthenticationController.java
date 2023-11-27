package com.group01.bits.controller;

import com.group01.bits.dto.AuthenticationRequestDTO;
import com.group01.bits.dto.AuthenticationResponseDTO;
import com.group01.bits.template.GeneralResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO
@RequestMapping("/api/v1/auth/")
public interface AuthenticationController {
    @PostMapping("register")
    GeneralResponse<AuthenticationResponseDTO> postRegister(@RequestBody AuthenticationRequestDTO request) throws Exception;

    @PostMapping("authenticate")
    ResponseEntity<AuthenticationResponseDTO> postAuthenticate(@RequestBody AuthenticationRequestDTO request);
}