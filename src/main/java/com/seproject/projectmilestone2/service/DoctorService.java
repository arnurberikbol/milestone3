package com.seproject.projectmilestone2.service;

import com.seproject.projectmilestone2.dto.DoctorDto;

import java.util.List;

public interface DoctorService {
    public List<DoctorDto> getAllDoctors();

    public boolean saveDoctor(DoctorDto doctorDto);

    public boolean persistDoctor(DoctorDto doctorDto);

    public DoctorDto getDoctor(int id);
}
