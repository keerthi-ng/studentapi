package com.telstra.studentapi.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.telstra.studentapi.exception.ApiException;
import com.telstra.studentapi.model.Student;
import com.telstra.studentapi.repository.StudentRepository;

@Component
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> getAllStudents() {	
		return studentRepo.findAll();
	}

	@Override
	public Optional<Student> getStudentById(String studentId) {
		Optional<Student> student = null;
			student = studentRepo.findById(studentId);
		return student;
	}

	@Override
	public Student getStudentByEmailId(String emailId) {
		Student student = null;
			student = studentRepo.findByEmail(emailId);
		if(null==student){
			throw new EntityNotFoundException("Student with emailId "+emailId+" not found");
		}
		return student;
	}

	@Override
	public Student getStudentByPhoneNo(String phoneNo) {
		Student student = null;
			student = studentRepo.findByPhone(phoneNo);
			if(null==student){
				throw new EntityNotFoundException("Student with phoneNo "+phoneNo+" not found");
			}
		return student;
	}

	@Override
	public Student addStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public Student updateStudent(String studentId, Student student) {
		Student studentFromRepo = studentRepo.getById(studentId);
		if(Objects.nonNull(student.getFirstname()) && !"".equalsIgnoreCase(student.getFirstname())) {
			studentFromRepo.setFirstname(student.getFirstname()); }
		if(Objects.nonNull(student.getLastname()) && !"".equalsIgnoreCase(student.getLastname())) {
			studentFromRepo.setLastname(student.getLastname()); }
		if(Objects.nonNull(student.getEmail()) && !"".equalsIgnoreCase(student.getEmail())) {
			studentFromRepo.setEmail(student.getEmail()); }
		if(Objects.nonNull(student.getPhone()) && !"".equalsIgnoreCase(student.getPhone())) {
			studentFromRepo.setPhone(student.getPhone()); }
		if(Objects.nonNull(student.getAge()) && !"".equalsIgnoreCase(student.getAge())) {
			studentFromRepo.setAge(student.getAge()); }
		
		BeanUtils.copyProperties(studentFromRepo, student);
		return studentRepo.save(studentFromRepo);
	}

	@Override
	public String deleteStudent(String studentId) throws Exception {
		Optional<Student> studentFromRepo = studentRepo.findById(studentId);
		if(studentFromRepo.isPresent()) {
			studentRepo.deleteById(studentId);
		}else {
			throw new EntityNotFoundException("Student With Id "+studentId+" not found to delete");
		}
		return "Successfully Deleted Student with Id: "+studentId;
	}

}
