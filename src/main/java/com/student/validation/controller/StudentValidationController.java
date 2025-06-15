package com.student.validation.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.common.icici.entity.Student;
import com.common.icici.repository.StudentRepository;
import com.student.validation.request.StudentDto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.Validator;

@RestController
@RequestMapping("/student")
public class StudentValidationController<T> {

	@Autowired
	private Validator validator;
	
	@Autowired
	private StudentRepository studentRepository;

	@PostMapping("/post")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public T storeStudentDetails(@Valid @RequestBody StudentDto student,
			@RequestHeader(name = "authorized", required = false, defaultValue = "false") String authorized) {
		//		student.setBirthDate(LocalDate.now());
		//		student.setPinCode("62363");

		System.out.println("Authorized Request " +authorized);
		Set<ConstraintViolation<StudentDto>> violations = validator.validate(student);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException("errorMessage", violations);
		}
		return (T) student;
	}
	
	@PostMapping("/store-student")
	public Student storeStudentDetails(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/{dept}")
	public List<Student> getStudentDetailsBasedOnDept(@PathVariable("dept") String dept) {
		return studentRepository.findByDept(dept);
	}
	
	
}
