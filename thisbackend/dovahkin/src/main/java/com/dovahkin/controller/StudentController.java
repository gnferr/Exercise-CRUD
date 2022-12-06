package com.dovahkin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dovahkin.model.Student;
import com.dovahkin.service.IStudentService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	IStudentService studentService;
	
	@PostMapping("/insert")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAll() {
		return studentService.getAll();
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable long id ,@RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/delete/{id}")
	public Student deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/getId/{id}")
	public Student getById(@PathVariable long id) {
		return studentService.getById(id);
	}
}
