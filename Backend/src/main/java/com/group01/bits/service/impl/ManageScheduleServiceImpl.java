package com.group01.bits.service.impl;

import com.group01.bits.dto.AvailableTimeDTO;
import com.group01.bits.dto.DeleteTemplateDTO;
import com.group01.bits.dto.ReviewDTO;
import com.group01.bits.dto.ScheduleDTO;
import com.group01.bits.entity.AvailableTime;
import com.group01.bits.entity.User;
import com.group01.bits.exception.BaseResponseException;
import com.group01.bits.repository.AvailableTimeRepository;
import com.group01.bits.repository.ScheduleRepository;
import com.group01.bits.repository.UserRepository;
import com.group01.bits.service.ManageScheduleService;
import com.group01.bits.template.ResponseStatusCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ManageScheduleServiceImpl implements ManageScheduleService {

    private final UserRepository userRepository;

    private final ScheduleRepository scheduleRepository;

    private final AvailableTimeRepository availableTimeRepository;
    @Override
    public AvailableTimeDTO addAvailableTime(Long id, Date startTime, Date endTime, String day) {
        User user = userRepository.findById(id).orElseThrow(BaseResponseException::new);
        AvailableTime availableTime = AvailableTime.builder()
                .startTime(startTime)
                .endTime(endTime)
                .dayAbbreviation(day)
                .user(user)
                .build();

        availableTimeRepository.save(availableTime);
        AvailableTimeDTO availableTimeDTO = AvailableTimeDTO.builder()
                .startTime(startTime)
                .endTime(endTime)
                .abbreviationDay(day)
                .build();
        return availableTimeDTO;
    }

    @Override
    public List<AvailableTimeDTO> getListOfAvailableTimeByTutorId(Long id) {
        List<AvailableTime> availableTimes = availableTimeRepository.findByUsedIds(id).orElseThrow(BaseResponseException::new);
        List<AvailableTimeDTO> dtos = new ArrayList<>();

        for(AvailableTime availableTime: availableTimes) {
            AvailableTimeDTO dto = AvailableTimeDTO.builder()
                    .abbreviationDay(availableTime.getDayAbbreviation())
                    .endTime(availableTime.getEndTime())
                    .startTime(availableTime.getStartTime())
                    .id(availableTime.getId())
                    .build();
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public DeleteTemplateDTO deleteTime(Long id) {
        Optional<AvailableTime> availableTime = availableTimeRepository.findById(id);
        DeleteTemplateDTO deleteTemplateDTO = DeleteTemplateDTO.builder().build();

        if (availableTime.isPresent()) {
            availableTimeRepository.delete(availableTime.get());
            deleteTemplateDTO.setAcknowledgement(true);
            deleteTemplateDTO.setNumberDeleted(1L);
        } else {
            deleteTemplateDTO.setAcknowledgement(false);
            deleteTemplateDTO.setNumberDeleted(0L);
            throw new BaseResponseException(ResponseStatusCode.builder().code("04").httpCode(HttpStatusCode.valueOf(200)).build());
        }
        return deleteTemplateDTO;
    }

    @Override
    public ScheduleDTO setSchedule(Long id) {
        return null;
    }

    @Override
    public ScheduleDTO updateSchedultStatus(Long id) {
        return null;
    }

    @Override
    public DeleteTemplateDTO deleteSchedule(Long id) {
        return null;
    }
}
