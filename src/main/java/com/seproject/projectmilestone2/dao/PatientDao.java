package com.seproject.projectmilestone2.dao;

import com.seproject.projectmilestone2.entity.Patient;

import java.util.List;

public interface PatientDao {

    public List<Patient> getAllPatients();

    public void savePatient(Patient patient);

    public void persistPatient(Patient patient);

    public Patient getPatient(int id);
}
