package com.jwt.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addStudent(Student Student) {
		sessionFactory.getCurrentSession().saveOrUpdate(Student);

	}

	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {

		return sessionFactory.getCurrentSession().createQuery("from Student")
				.list();
	}

	@Override
	public void deleteStudent(Integer Rollnum) {
		Student Student = (Student) sessionFactory.getCurrentSession().load(
				Student.class, Rollnum);
		if (null != Student) {
			this.sessionFactory.getCurrentSession().delete(Student);
		}

	}

	public Student getStudent(int Rollnum) {
		return (Student) sessionFactory.getCurrentSession().get(
				Student.class, Rollnum);
	}

	@Override
	public Student updateStudent(Student Student) {
		sessionFactory.getCurrentSession().update(Student);
		return Student;
	}

}