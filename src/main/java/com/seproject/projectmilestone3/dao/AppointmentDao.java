package com.seproject.projectmilestone3.dao;


import com.seproject.projectmilestone3.entity.Appointment;

import java.util.List;

public interface AppointmentDao {
    public List<Appointment> getAllAppointments();

    public void saveAppointment(Appointment appointment);

    public void persistAppointment(Appointment appointment);

    public Appointment getAppointment(int id);
}