package com.group01.bits.service;

import com.group01.bits.dto.SubjectDTO;
import com.group01.bits.dto.UserDTO;

import java.util.List;


public interface ManageAccountService {
    UserDTO addSubjects(List<SubjectDTO> subjects, String email);
    UserDTO addSchedule(UserDTO userDTO);
    List<UserDTO> getTutorByName(String name);
    List<UserDTO> getTutorBySubject(SubjectDTO subject);
}
