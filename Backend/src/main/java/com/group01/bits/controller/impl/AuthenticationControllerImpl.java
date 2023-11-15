package com.group01.bits.controller.impl;

import com.group01.bits.controller.AuthenticationController;
import com.group01.bits.dto.AuthenticationRequestDTO;
import com.group01.bits.dto.AuthenticationResponseDTO;
import com.group01.bits.service.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    @Override
    public ResponseEntity<AuthenticationResponseDTO> postRegister(AuthenticationRequestDTO request) {
        log.info(request.toString());
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.register(request);
        return ResponseEntity.ok(authenticationResponseDTO);
    }

    @Override
    public ResponseEntity<AuthenticationResponseDTO> postAuthenticate(AuthenticationRequestDTO request) {
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.authenticate(request);
        return ResponseEntity.ok(authenticationResponseDTO);
    }
}
