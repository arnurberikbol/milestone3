package com.seproject.projectmilestone3.dao;

import com.seproject.projectmilestone3.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class PatientDaoImpl implements PatientDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Patient> getAllPatients() {
        Query query = entityManager.createQuery("from Patient");
        List<Patient> allPatients = query.getResultList();
        return allPatients;
    }

    @Override
    @Transactional
    public void savePatient(Patient patient) {
        entityManager.merge(patient);
    }

    @Override
    @Transactional
    public void persistPatient(Patient patient) {
        entityManager.persist(patient);
    }

    @Override
    public Patient getPatient(int id) {
        Patient patient = entityManager.find(Patient.class,id);
        return patient;
    }
}
