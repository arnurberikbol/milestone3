package com.seproject.projectmilestone2.dao;

import com.seproject.projectmilestone2.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDBRepository extends JpaRepository<Doctor, String> {
}
