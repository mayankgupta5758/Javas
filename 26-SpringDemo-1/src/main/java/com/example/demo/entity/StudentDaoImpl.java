package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDAO {

	private EntityManager entityManager;

	@Autowired
	public StudentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Student theStudent) {

		entityManager.persist(theStudent);
	}

	@Override
	public Student findById(Integer id) {

		return entityManager.find(Student.class, id);
	}

	@Override
	public List<Student> readAllStudent() {
		TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
		return query.getResultList();
	}
}




