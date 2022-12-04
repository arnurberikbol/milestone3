package com.seproject.projectmilestone3.service;

import com.seproject.projectmilestone3.converter.AppointmentConverter;
import com.seproject.projectmilestone3.dao.AppointmentDao;
import com.seproject.projectmilestone3.dto.AppointmentDto;
import com.seproject.projectmilestone3.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppoinmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired
    private AppointmentConverter appointmentConverter;

    @Override
    @Transactional
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> allAppointments = appointmentDao.getAllAppointments();
        return appointmentConverter.entityToDto(allAppointments);
    }


    @Override
    public boolean saveAppointment(AppointmentDto appointmentDto) {

        try {
            Appointment appointment = appointmentConverter.dtoToEntity(appointmentDto);
            appointmentDao.saveAppointment(appointment);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean persistAppointment(AppointmentDto appointmentDto) {
        try {
            Appointment appointment = AppointmentConverter.dtoToEntity(appointmentDto);
            appointmentDao.persistAppointment(appointment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    @Transactional
    public AppointmentDto getAppointment(int id) {
        Appointment appointment = appointmentDao.getAppointment(id);
        return appointmentConverter.entityToDto(appointment);
    }
}
