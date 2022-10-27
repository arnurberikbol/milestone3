package com.seproject.projectmilestone2.service;

import com.seproject.projectmilestone2.converter.PatientConverter;
import com.seproject.projectmilestone2.dao.PatientDao;
import com.seproject.projectmilestone2.dto.PatientDto;
import com.seproject.projectmilestone2.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientConverter patientConverter;

    @Override
    @Transactional
    public List<PatientDto> getAllPatients() {
        List<Patient> allPatients = patientDao.getAllPatients();
        return patientConverter.entityToDto(allPatients);
    }

    @Override
    public boolean savePatient(PatientDto patientDto) {
        try {
            Patient patient = patientConverter.dtoToEntity(patientDto);
            patientDao.savePatient(patient);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean persistPatient(PatientDto patientDto) {
        Patient patient = patientConverter.dtoToEntity(patientDto);
        try {
            patientDao.persistPatient(patient);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public PatientDto getPatient(int id) {
        Patient patient = patientDao.getPatient(id);
        return patientConverter.entityToDto(patient);
    }
}
