package com.group01.bits.controller.impl;

import com.group01.bits.controller.AccountManagementController;
import com.group01.bits.dto.QualificationDTO;
import com.group01.bits.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public class AccountManagementControllerImpl implements AccountManagementController {
    @Override
    public ResponseEntity<UserDTO> getTutorByName(UserDTO request) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> getTutorBySubject(UserDTO request) {
        return null;
    }

    @Override
    public ResponseEntity<QualificationDTO> getQualifications(UserDTO request) {
        return null;
    }
}
