package com.seproject.projectmilestone2.service;

import com.seproject.projectmilestone2.converter.DoctorConverter;
import com.seproject.projectmilestone2.dao.DoctorDao;
import com.seproject.projectmilestone2.dto.DoctorDto;
import com.seproject.projectmilestone2.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private DoctorConverter doctorConverter;

    @Override
    @Transactional
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> allDoctors = doctorDao.getAllDoctors();
        return doctorConverter.entityToDto(allDoctors);
    }


    @Override
    public boolean saveDoctor(DoctorDto doctorDto) {
        try {
            Doctor doctor = doctorConverter.dtoToEntity(doctorDto);
            doctorDao.saveDoctor(doctor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean persistDoctor(DoctorDto doctorDto) {
        Doctor doctor = doctorConverter.dtoToEntity(doctorDto);
        try {
            doctorDao.persistDoctor(doctor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    @Override
    @Transactional
    public DoctorDto getDoctor(int id) {
        Doctor doctor = doctorDao.getDoctor(id);
        return doctorConverter.entityToDto(doctor);
    }
}
