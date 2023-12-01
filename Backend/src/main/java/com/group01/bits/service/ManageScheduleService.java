package com.group01.bits.service;

import com.group01.bits.dto.AvailableTimeDTO;
import com.group01.bits.dto.DeleteTemplateDTO;
import com.group01.bits.dto.ReviewDTO;
import com.group01.bits.dto.ScheduleDTO;
import com.group01.bits.entity.Schedule;

import java.util.Date;
import java.util.List;

public interface ManageScheduleService {
    AvailableTimeDTO addAvailableTime(Long id, Date startTime, Date endTime, String day);

    List<AvailableTimeDTO> getListOfAvailableTimeByTutorId(Long id);
    DeleteTemplateDTO deleteTime(Long id);
    ScheduleDTO setSchedule(Long id);

    ScheduleDTO updateSchedultStatus(Long id);

    DeleteTemplateDTO deleteSchedule(Long id);

}
