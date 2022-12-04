package com.seproject.projectmilestone3.dto;

import javax.persistence.*;

public class AppointmentDto {

    private int id;

    private String patient_name;

    private String patient_surname;

    private String doctor_name;

    private String doctor_surname;

    private String doctor_spec;

    private String date;

    private String contact_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_surname() {
        return patient_surname;
    }

    public void setPatient_surname(String patient_surname) {
        this.patient_surname = patient_surname;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getDoctor_surname() {
        return doctor_surname;
    }

    public void setDoctor_surname(String doctor_surname) {
        this.doctor_surname = doctor_surname;
    }

    public String getDoctor_spec() {
        return doctor_spec;
    }

    public void setDoctor_spec(String doctor_spec) {
        this.doctor_spec = doctor_spec;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    @Override
    public String toString() {
        return "AppointmentDto{" +
                "patient_name='" + patient_name + '\'' +
                ", patient_surname='" + patient_surname + '\'' +
                ", doctor_name='" + doctor_name + '\'' +
                ", doctor_surname='" + doctor_surname + '\'' +
                ", doctor_spec='" + doctor_spec + '\'' +
                ", date='" + date + '\'' +
                ", contact_number='" + contact_number + '\'' +
                '}';
    }
}
