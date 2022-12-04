package com.seproject.projectmilestone3.dao;


import com.seproject.projectmilestone3.entity.Doctor;

import java.util.List;

public interface DoctorDao {
    public List<Doctor> getAllDoctors();

    public void saveDoctor(Doctor doctor);

    public void persistDoctor(Doctor doctor);

    public Doctor getDoctor(int id);

    public List<Doctor> searchDoctors(String name);

    public List<Doctor> searchDoctorsBySpec(String spec);
}