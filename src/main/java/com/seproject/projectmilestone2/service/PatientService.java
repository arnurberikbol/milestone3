package com.seproject.projectmilestone2.service;

import com.seproject.projectmilestone2.dto.PatientDto;

import java.util.List;

public interface PatientService {
    public List<PatientDto> getAllPatients();

    public boolean savePatient(PatientDto patientDto);

    public boolean persistPatient(PatientDto patientDto);

    public PatientDto getPatient(int id);
}
