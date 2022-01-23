package com.telstra.studentapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.telstra.studentapi.model.Student;

@Service
public interface StudentService {

	public List<Student> getAllStudents();

	public Optional<Student> getStudentById(String studentId);

	public Student getStudentByEmailId(String emailId);

	public Student getStudentByPhoneNo(String phoneNo);

	public Student addStudent(Student student);

	public Student updateStudent(String studentId, Student student);

	public String deleteStudent(String studentId) throws Exception;

}
