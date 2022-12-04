package com.seproject.projectmilestone3.dao;

import com.seproject.projectmilestone3.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.*;

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

    @Override
    public List<Doctor> searchDoctors(String name) {
        String[] splited = name.split(" ");
        Set<Doctor> allDoctor = new LinkedHashSet<Doctor>();
        if (splited.length == 2) {
            Query query = entityManager.createQuery("from Doctor " +
                    "where name like '%" + splited[0] + "%' and surname like '%" + splited[1] + "%'");
            List<Doctor> doctors1 = query.getResultList();
            allDoctor.addAll(doctors1);

            query = entityManager.createQuery("from Doctor " +
                    "where name like '%" + splited[1] + "%' and surname like '%" + splited[0] + "%'");
            List<Doctor> doctors2 = query.getResultList();

            allDoctor.addAll(doctors2);
        }
        if (splited.length == 1) {
            Query query = entityManager.createQuery("from Doctor " +
                    "where name like '%" + splited[0] + "%'");
            List<Doctor> doctors1 = query.getResultList();
            allDoctor.addAll(doctors1);

            query = entityManager.createQuery("from Doctor " +
                    "where surname like '%" + splited[0] + "%'");
            List<Doctor> doctors2 = query.getResultList();

            allDoctor.addAll(doctors2);
        }

        List<Doctor> finalDoctor = new ArrayList<>(allDoctor);
        return finalDoctor;
    }

    @Override
    public List<Doctor> searchDoctorsBySpec(String spec) {
        Query query = entityManager.createQuery("from Doctor " +
                "where category = " + spec);
        List<Doctor> doctors = query.getResultList();
       return doctors;
    }
}