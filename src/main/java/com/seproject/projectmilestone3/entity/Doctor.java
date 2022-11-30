package com.seproject.projectmilestone3.entity;

import javax.persistence.*;

@Entity
@Table(name = "Doctors")
public class Doctor {

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

    @Column(name = "contact_number")
    private String contact_number;

    @Column(name = "department_id")
    private int department_id;

    @Column(name = "specialization_details_id")
    private int specialization_details_id;

    @Column(name = "experience")
    private int experience;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "photo_name")
    private String photo_name;

    @Column(name = "photo_type")
    private String photo_type;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private int price;

    @Column(name = "schedule_details")
    private String schedule_details;

    @Column(name = "degree")
    private String degree;

    @Column(name = "rating")
    private int rating;

    @Column(name = "address")
    private String address;

    public int getId() {
        return id;
    }

    public Doctor() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
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

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getSpecialization_details_id() {
        return specialization_details_id;
    }

    public void setSpecialization_details_id(int specialization_details_id) {
        this.specialization_details_id = specialization_details_id;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSchedule_details() {
        return schedule_details;
    }

    public void setSchedule_details(String schedule_details) {
        this.schedule_details = schedule_details;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoto_name() {
        return photo_name;
    }

    public void setPhoto_name(String photo_name) {
        this.photo_name = photo_name;
    }

    public String getPhoto_type() {
        return photo_type;
    }

    public void setPhoto_type(String photo_type) {
        this.photo_type = photo_type;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "date_of_birth=" + date_of_birth +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", contact_number=" + contact_number +
                ", department_id=" + department_id +
                ", specialization_details_id=" + specialization_details_id +
                ", experience=" + experience +
                ", photo='" + photo + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", schedule_details='" + schedule_details + '\'' +
                ", degree='" + degree + '\'' +
                ", rating=" + rating +
                ", address='" + address + '\'' +
                '}';
    }
}

