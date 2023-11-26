package com.group01.bits.service.impl;

import com.group01.bits.constants.Role;
import com.group01.bits.dto.SubjectDTO;
import com.group01.bits.entity.Subject;
import com.group01.bits.repository.SubjectRepository;
import com.group01.bits.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.scanner.Constant;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BaseServiceImpl implements BaseService {

    private final SubjectRepository subjectRepository;

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

    @Override
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        List<SubjectDTO> subjectDTOS = new ArrayList<>();

        for (Subject subject : subjects) {
            SubjectDTO dto = SubjectDTO.builder()
                    .subjectID(subject.getSubjectID())
                    .description(subject.getDescription())
                    .subjectName(subject.getSubjectName())
                    .build();
            subjectDTOS.add(dto);
        }
        return subjectDTOS;
    }
}
