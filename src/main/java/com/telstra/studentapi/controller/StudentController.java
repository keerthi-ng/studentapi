package com.telstra.studentapi.controller;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telstra.studentapi.model.Student;
import com.telstra.studentapi.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public ResponseEntity<List<Student>> getStudentList(){
		return new ResponseEntity<>(studentService.getAllStudents(),HttpStatus.OK);
	}
	
	@GetMapping("/{studentId}")
	public ResponseEntity<?> getStudentById(@PathVariable String studentId){
		Optional<Student> studentFromRepo = studentService.getStudentById(studentId);
	if(!studentFromRepo.isPresent()) {
		return new ResponseEntity<>("Student with id "+studentId+" does not exist",HttpStatus.BAD_REQUEST);
	}
		return new ResponseEntity<>(studentFromRepo.get(),HttpStatus.OK);
	}
	
	@GetMapping("/email/{emailId}")
	public ResponseEntity<Student> getStudentByEmail(@PathVariable String emailId){
		Student studentFromRepo = studentService.getStudentByEmailId(emailId);
		return new ResponseEntity<>(studentFromRepo,HttpStatus.OK);
	}
	
	@GetMapping("/phone/{phoneNo}")
	public ResponseEntity<Student> getStudentByPhoneNo(@PathVariable String phoneNo){
		Student studentFromRepo = studentService.getStudentByPhoneNo(phoneNo);
		return new ResponseEntity<>(studentFromRepo,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student studentFromRepo = studentService.addStudent(student);
		return new ResponseEntity<>(studentFromRepo,HttpStatus.OK);
	}
	
	@PutMapping("/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable String studentId,@RequestBody Student student){
		Student studentFromRepo = studentService.updateStudent(studentId,student);
		return new ResponseEntity<>(studentFromRepo,HttpStatus.OK);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable String studentId) throws Exception{
		String message = studentService.deleteStudent(studentId);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}

}
