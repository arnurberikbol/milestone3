package com.seproject.projectmilestone3.converter;

import com.seproject.projectmilestone3.dto.AppointmentDto;
import com.seproject.projectmilestone3.entity.Appointment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppointmentConverter {

    public static AppointmentDto entityToDto(Appointment appointment) {
        AppointmentDto appointmentDto = new AppointmentDto();

        appointmentDto.setId(appointment.getId());
        appointmentDto.setPatient_name(appointment.getPatient_name());
        appointmentDto.setPatient_surname(appointment.getPatient_surname());
        appointmentDto.setDoctor_name(appointment.getDoctor_name());
        appointmentDto.setDoctor_surname(appointment.getDoctor_surname());
        appointmentDto.setDoctor_spec(appointment.getDoctor_spec());
        appointmentDto.setDate(appointment.getDate());
        appointmentDto.setContact_number(appointment.getContact_number());

        return appointmentDto;
    }

    public static List<AppointmentDto> entityToDto(List<Appointment> appointment) {
        return appointment.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public static Appointment dtoToEntity(AppointmentDto appointmentDto) {
        Appointment appointment = new Appointment();

        appointment.setId(appointmentDto.getId());
        appointment.setPatient_name(appointmentDto.getPatient_name());
        appointment.setPatient_surname(appointmentDto.getPatient_surname());
        appointment.setDoctor_name(appointmentDto.getDoctor_name());
        appointment.setDoctor_surname(appointmentDto.getDoctor_surname());
        appointment.setDoctor_spec(appointmentDto.getDoctor_spec());
        appointment.setDate(appointmentDto.getDate());
        appointment.setContact_number(appointmentDto.getContact_number());

        return appointment;
    }

    public static List<Appointment> dtoToEntity(List<AppointmentDto> appointmentDto) {
        return appointmentDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
