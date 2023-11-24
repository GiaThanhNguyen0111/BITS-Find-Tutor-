package com.group01.bits.controller.impl;

import com.group01.bits.appfilter.AppFilter;
import com.group01.bits.constants.Role;
import com.group01.bits.controller.AccountManagementController;
import com.group01.bits.dto.AvailableTimeDTO;
import com.group01.bits.dto.QualificationDTO;
import com.group01.bits.dto.SubjectDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.entity.AvailableTime;
import com.group01.bits.service.BaseService;
import com.group01.bits.service.ManageAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO

@RestController
@AllArgsConstructor
@Slf4j
public class AccountManagementControllerImpl implements AccountManagementController {

    private final ManageAccountService manageAccountService;

    private final BaseService baseService;

    private final AppFilter.JwtAdapter jwtAdapter;


    @Override
    public ResponseEntity<List<UserDTO>> getTutorByName(UserDTO request) {
        return ResponseEntity.ok(manageAccountService.getTutorByName(request.getFullName()));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getTutorBySubject(SubjectDTO request) {
        List<UserDTO> userDTOs= manageAccountService.getTutorBySubject(request);
        return ResponseEntity.ok(userDTOs);
    }

    @Override
    public ResponseEntity<List<QualificationDTO>> getQualifications(UserDTO request, String authorizationString) {
        String jwtToken = baseService.extractToken(authorizationString);
        String email = jwtAdapter.extractUsername(jwtToken);
        return ResponseEntity.ok(manageAccountService.getQualifications(email));
    }

    @Override
    public ResponseEntity<UserDTO> postAddSubjects(List<SubjectDTO> request, String authorizationString) {
        String jwtToken = baseService.extractToken(authorizationString);
        String role = jwtAdapter.extractRole(jwtToken);
        UserDTO user = new UserDTO();
        if (Role.TUTOR.equals(role)) {
            user = manageAccountService.addSubjects(request, jwtAdapter.extractUsername(jwtToken));
        } else {
            throw new RuntimeException();
        }
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<UserDTO> postAddSchedule(UserDTO request, String authorizationString) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> postAddQualification(UserDTO request, String authorizationString) {
        return null;
    }

    @Override
    public ResponseEntity<List<AvailableTime>> postAddAvailableTime(AvailableTimeDTO request, String authorizationString) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserDTO>> getAllTutor() {
        return ResponseEntity.ok(manageAccountService.getAllTutor());
    }

}
