package com.dovahkin.repository;

import java.util.List;

import com.dovahkin.model.Student;

public interface IStudentRepository {
	public Student insertStudent(Student student);
	public List<Student> getAll();
	public Student updateStudent(long id,Student student);
	public Student deleteStudent(long id);
	public Student getById(long id);
}
