package com.cg.iter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.iter.bean.Student;
import com.cg.iter.dao.StudentDao;
@Component
public class StudentServiceimpl implements StudentService {
	@Autowired
	private StudentDao studDao;
	public StudentServiceimpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "StudentServiceimpl [studDao=" + studDao + "]";
	}

	@Override
	public boolean create(Student stud) {
		// TODO Auto-generated method stub
		return studDao.create(stud);
	}

	@Override
	public Student getstud(int id) {
		// TODO Auto-generated method stub
		return studDao.getstud(id);
	}

	@Override
	public boolean update(Student stud) {
		// TODO Auto-generated method stub
		return studDao.update(stud);
	}

	@Override
	public boolean delete(Student stud) {
		// TODO Auto-generated method stub
		return studDao.delete(stud);
	}

}
