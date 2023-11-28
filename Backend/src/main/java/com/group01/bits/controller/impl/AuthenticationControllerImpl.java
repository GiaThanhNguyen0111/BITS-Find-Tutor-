package com.group01.bits.controller.impl;

import com.group01.bits.controller.AuthenticationController;
import com.group01.bits.dto.AuthenticationRequestDTO;
import com.group01.bits.dto.AuthenticationResponseDTO;
import com.group01.bits.service.AuthenticationService;
import com.group01.bits.template.GeneralResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationService authenticationService;

    @Override
    public GeneralResponse<AuthenticationResponseDTO> postRegister(AuthenticationRequestDTO request) throws Exception {
        log.info(request.toString());
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.register(request);
        return new GeneralResponse<AuthenticationResponseDTO>().success(authenticationResponseDTO);
    }

    @Override
    public GeneralResponse<AuthenticationResponseDTO> postAuthenticate(AuthenticationRequestDTO request) {
        AuthenticationResponseDTO authenticationResponseDTO = authenticationService.authenticate(request);
        return new GeneralResponse<AuthenticationResponseDTO>().success(authenticationResponseDTO);
    }
}
