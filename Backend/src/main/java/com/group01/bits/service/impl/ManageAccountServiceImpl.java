package com.group01.bits.service.impl;

import com.group01.bits.constants.CacheConstant;
import com.group01.bits.dto.QualificationDTO;
import com.group01.bits.dto.SubjectDTO;
import com.group01.bits.dto.UserDTO;
import com.group01.bits.entity.Qualification;
import com.group01.bits.entity.Subject;
import com.group01.bits.entity.User;
import com.group01.bits.repository.QualificationRepository;
import com.group01.bits.repository.SubjectRepository;
import com.group01.bits.repository.UserRepository;
import com.group01.bits.service.ManageAccountService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManageAccountServiceImpl implements ManageAccountService {

    private final UserRepository userRepository;

    private final SubjectRepository subjectRepository;

    private final QualificationRepository qualificationRepository;

    @Override
    @Transactional
    public UserDTO addSubjects(List<SubjectDTO> subjects, String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        List<Subject> subjects1 = new ArrayList<>();
        for(SubjectDTO subject: subjects) {
            Subject sub = subjectRepository.findById(subject.getSubjectID()).orElseThrow();
            subjects1.add(sub);
        }
        UserDTO userDTO1 = UserDTO.builder()
                .userID(user.getUserID())
                .fullName(user.getUsername())
                .major(user.getMajor())
                .qualifications(user.getQualifications())
                .birthDay(user.getBirthDay())
                .build();
        Long userId = user.getUserID();
        user.setSubjects(subjects1);

        userRepository.save(user);
        return userDTO1;
    }

    @Override
    public UserDTO addSchedule(UserDTO userDTO) {
        return null;
    }


    @Override
    @Cacheable(value= CacheConstant.TUTOR_CACHE, key="#name", unless="#result == null")
    public List<UserDTO> getTutorByName(String name) {
        List<UserDTO> userDTOs = new ArrayList<>();
        List<User> users = userRepository.findTutorByName(name).orElseThrow(() -> new UsernameNotFoundException("User's name not found"));
        for (User user : users) {
            UserDTO userDTO = UserDTO.builder()
                    .userID(user.getUserID())
                    .fullName(user.getUsername())
                    .major(user.getMajor())
                    .qualifications(user.getQualifications())
                    .birthDay(user.getBirthDay())
                    .build();
            userDTOs.add(userDTO);
        }
        log.info("==== userDTOS get Tutor By Name =======: {}", userDTOs.toString());
        return userDTOs;
    }

    @Override
    @Cacheable(value= CacheConstant.TUTOR_CACHE, key="#name", unless="#result == null")
    public List<UserDTO> getTutorBySubject(SubjectDTO subject) {
        List<UserDTO> userDTOs = new ArrayList<>();
        Subject selectedSubject = subjectRepository.findById(subject.getSubjectID()).orElseThrow();
        List<User> users = selectedSubject.getUsers();
        for (User user : users) {
            UserDTO userDTO = UserDTO.builder()
                    .userID(user.getUserID())
                    .fullName(user.getUsername())
                    .major(user.getMajor())
                    .qualifications(user.getQualifications())
                    .birthDay(user.getBirthDay())
                    .build();
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    @Override
    public List<UserDTO> getAllTutor() throws EntityNotFoundException {
        List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.findAllTutor().orElseThrow();
        for (User user: users) {
            UserDTO userDTO = UserDTO.builder()
                    .userID(user.getUserID())
                    .birthDay(user.getBirthDay())
                    .qualifications(user.getQualifications())
                    .role(user.getRole())
                    .subjects(user.getSubjects())
                    .availableTimes(user.getAvailableTimes())
                    .major(user.getMajor())
                    .build();
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public List<QualificationDTO> getQualifications(String email) {
        User user = userRepository.findByEmail(email).orElseThrow();
        Long userId = user.getUserID();
        List<Qualification> qualifications = qualificationRepository.getQualificationByUserId(userId).orElseThrow();
        List<QualificationDTO> qualificationDTOS =new ArrayList<>();
        for (Qualification qualification: qualifications) {
            QualificationDTO qualificationDTO = QualificationDTO.builder()
                    .qualificationID(qualification.getQualificationID())
                    .description(qualification.getDescription())
                    .expiryDate(qualification.getExpiryDate())
                    .build();
            qualificationDTOS.add(qualificationDTO);
        }
        return qualificationDTOS;
    }
}
