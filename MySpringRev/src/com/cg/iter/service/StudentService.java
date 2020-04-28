package com.cg.iter.service;

import com.cg.iter.bean.Student;

public interface StudentService {

	boolean create(Student stud);

	Student getstud(int nextInt);

	boolean update(Student stud);

	boolean delete(Student stud);

}
