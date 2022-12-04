package com.seproject.projectmilestone3.service;

import com.seproject.projectmilestone3.dto.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    public List<AppointmentDto> getAllAppointments();

    public boolean saveAppointment(AppointmentDto appointmentDto);

    public boolean persistAppointment(AppointmentDto appointmentDto);

    public AppointmentDto getAppointment(int id);
}
