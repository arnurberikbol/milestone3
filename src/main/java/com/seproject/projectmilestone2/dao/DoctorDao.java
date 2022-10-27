package com.seproject.projectmilestone2.dao;


import com.seproject.projectmilestone2.entity.Doctor;

import java.util.List;

public interface DoctorDao {
    public List<Doctor> getAllDoctors();

    public void saveDoctor(Doctor doctor);

    public void persistDoctor(Doctor doctor);

    public Doctor getDoctor(int id);
}