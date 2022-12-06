package com.dovahkin.repository.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dovahkin.model.Student;
import com.dovahkin.repository.IStudentRepository;

@Repository
public class StudentRepository implements IStudentRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Student insertStudent(Student student) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_student(nama,umur,email,hard_skill,soft_skill,interest,jenis_kelamin,deskripsi_diri) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(query,new Object[] {student.getNama(),student.getUmur(),student.getEmail(),student.getHard_skill(),student.getSoft_skill(),student.getInterest()
				,student.getJenis_kelamin(),student.getDeskripsi_diri()});
		return student;
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Student.class));
	}

	@Override
	public Student updateStudent(long id, Student student) {
		// TODO Auto-generated method stub
		String query = ("UPDATE tb_student SET nama = ? , umur = ?, email = ? , hard_skill = ? , soft_skill = ? "
				+ ", interest = ? , jenis_kelamin = ? , deskripsi_diri = ? WHERE id = ?");
		jdbcTemplate.update(query , new Object[] {student.getNama(),student.getUmur(),student.getEmail(),student.getHard_skill(),student.getSoft_skill()
				,student.getInterest(),student.getJenis_kelamin(),student.getDeskripsi_diri(),id});
		return student;
	}

	@Override
	public Student deleteStudent(long id) {
		// TODO Auto-generated method stub
		String query = ("SELECT * FROM tb_student WHERE id = ?");
		var result = jdbcTemplate.queryForObject(query , new BeanPropertyRowMapper<>(Student.class),id);
		
		query = ("DELETE FROM tb_student WHERE id = ?");
		jdbcTemplate.update(query,id);
		return result;
	}

	@Override
	public Student getById(long id) {
		// TODO Auto-generated method stub
		String query = ("SELECT * FROM tb_student WHERE id = ?");
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Student.class),id);
	}
	
}
