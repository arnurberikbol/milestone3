package com.seproject.projectmilestone2.dao;

import com.seproject.projectmilestone2.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DoctorDaoImpl implements DoctorDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Doctor> getAllDoctors() {
        Query query = entityManager.createQuery("from Doctor");
        List<Doctor> allDoctors = query.getResultList();
        return allDoctors;
    }

    @Override
    @Transactional
    public void saveDoctor(Doctor doctor) {
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        System.out.println(doctor.getPhoto());
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
        entityManager.merge(doctor);
    }

    @Override
    @Transactional
    public void persistDoctor(Doctor doctor) {
        entityManager.persist(doctor);
    }

    @Override
    public Doctor getDoctor(int id) {
        Doctor doctor = entityManager.find(Doctor.class,id);
        return doctor;
    }
}