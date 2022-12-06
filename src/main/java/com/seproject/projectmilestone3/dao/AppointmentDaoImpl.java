package com.seproject.projectmilestone3.dao;

import com.seproject.projectmilestone3.entity.Appointment;
import com.seproject.projectmilestone3.entity.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class AppointmentDaoImpl implements AppointmentDao {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Appointment> getAllAppointments() {
        Query query = entityManager.createQuery("from Appointment");
        List<Appointment> allAppointments = query.getResultList();
        return allAppointments;
    }

    @Override
    @Transactional
    public void saveAppointment(Appointment appointment) {
        entityManager.merge(appointment);
    }

    @Override
    @Transactional
    public void persistAppointment(Appointment appointment) {
        entityManager.persist(appointment);
    }

    @Override
    public Appointment getAppointment(int id) {
        Appointment appointment = entityManager.find(Appointment.class,id);
        return appointment;
    }
}