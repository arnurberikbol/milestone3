package com.seproject.projectmilestone3.converter;


import com.seproject.projectmilestone3.dto.PatientDto;
import com.seproject.projectmilestone3.entity.Patient;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PatientConverter {
    public static PatientDto entityToDto(Patient patient) {
        PatientDto patientDto = new PatientDto();

        patientDto.setId(patient.getId());
        patientDto.setIin(patient.getIin());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setMiddlename(patient.getMiddlename());
        patientDto.setDate_of_birth(patient.getDate_of_birth());
        patientDto.setAddress(patient.getAddress());
        patientDto.setEmergency_contact_number(patient.getEmergency_contact_number());
        patientDto.setContact_number(patient.getContact_number());
        patientDto.setBlood_group(patient.getBlood_group());
        patientDto.setEmail(patient.getEmail());
        patientDto.setMarital_status(patient.getMarital_status());
        patientDto.setRegistration_date(patient.getRegistration_date());

        return patientDto;
    }

    public static List<PatientDto> entityToDto(List<Patient> patient) {
        return patient.stream().map(x -> entityToDto(x)).collect(Collectors.toList());
    }

    public static Patient dtoToEntity(PatientDto patientDto) {
        Patient patient = new Patient();

        patient.setId(patientDto.getId());
        patient.setIin(patientDto.getIin());
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setMiddlename(patientDto.getMiddlename());
        patient.setDate_of_birth(patientDto.getDate_of_birth());
        patient.setAddress(patientDto.getAddress());
        patient.setEmergency_contact_number(patientDto.getEmergency_contact_number());
        patient.setContact_number(patientDto.getContact_number());
        patient.setBlood_group(patientDto.getBlood_group());
        patient.setEmail(patientDto.getEmail());
        patient.setMarital_status(patientDto.getMarital_status());
        patient.setRegistration_date(patientDto.getRegistration_date());

        return patient;
    }

    public static List<Patient> dtoToEntity(List<PatientDto> patientDto) {
        return patientDto.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
    }
}
