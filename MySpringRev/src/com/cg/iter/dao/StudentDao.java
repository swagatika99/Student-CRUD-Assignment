package com.cg.iter.dao;

import com.cg.iter.bean.Student;

public interface StudentDao {

	boolean create(Student stud);

	Student getstud(int id);

	boolean update(Student stud);

	boolean delete(Student stud);

}
