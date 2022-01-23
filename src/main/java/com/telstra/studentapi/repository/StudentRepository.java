package com.telstra.studentapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telstra.studentapi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

	Student findByEmail(String emailId);

	Student findByPhone(String phoneNo);

}
