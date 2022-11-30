package com.seproject.projectmilestone3.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_of_birth")
    private String date_of_birth;

    @Column(name = "iin")
    private String iin;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middlename;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "marital_status")
    private String marital_status;

    @Column(name = "registration_date")
    private LocalDate registration_date;

    @Column(name = "blood_group")
    private int blood_group;

    @Column(name = "emergency_contact_number")
    private String emergency_contact_number;

    @Column(name = "contact_number")
    private String contact_number;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public LocalDate getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }

    public int getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(int blood_group) {
        this.blood_group = blood_group;
    }

    public String getEmergency_contact_number() {
        return emergency_contact_number;
    }

    public void setEmergency_contact_number(String emergency_contact_number) {
        this.emergency_contact_number = emergency_contact_number;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "date_of_birth=" + date_of_birth +
                ", iin=" + iin +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", marital_status='" + marital_status + '\'' +
                ", registration_date=" + registration_date +
                ", blood_group=" + blood_group +
                ", emergency_contact_number=" + emergency_contact_number +
                ", contact_number=" + contact_number +
                '}';
    }
}
