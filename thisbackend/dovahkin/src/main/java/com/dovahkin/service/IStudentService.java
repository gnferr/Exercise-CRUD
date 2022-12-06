package com.dovahkin.service;

import java.util.List;

import com.dovahkin.model.Student;

public interface IStudentService {
	public Student insertStudent(Student student);
	public List<Student> getAll();
	public Student updateStudent(long id,Student student);
	public Student deleteStudent(long id);
	public Student getById(long id);
}
