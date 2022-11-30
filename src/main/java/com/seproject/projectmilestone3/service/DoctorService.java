package com.seproject.projectmilestone3.service;

import com.seproject.projectmilestone3.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    public List<DoctorDto> getAllDoctors();

    public boolean saveDoctor(DoctorDto doctorDto);

    public boolean persistDoctor(DoctorDto doctorDto);

    public DoctorDto getDoctor(int id);
}
