package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Employee nulla) {
		entityManager.persist(nulla);
	}

	@Override
	public Employee getById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public List<Employee> readAll() {
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee", Employee.class);
		return typedQuery.getResultList();
	}

	@Override
	@Transactional
	public void updateById(int id) {
		Query query = entityManager
				.createQuery("UPDATE Employee e SET e.salary = :salary, e.age = :age WHERE e.id = :id");

		query.setParameter("salary", 50000);
		query.setParameter("age", 22);
		query.setParameter("id", 1);

		int updatedRows = query.executeUpdate();
		System.out.println("Rows updated: " + updatedRows);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Query query = entityManager.createQuery("DELETE FROM Employee e WHERE e.id = :id");

		query.setParameter("id", 1);

		int deletedRows = query.executeUpdate();
		System.out.println("Rows deleted: " + deletedRows);
	}

	@Override
	public List<Employee> readByName(String name) {
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee where name= :data", Employee.class);
		typedQuery.setParameter("data", name);
		return typedQuery.getResultList();
	}

	@Override
	public List<Employee> readByAge(int age) {
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee where age = :ages", Employee.class);
		typedQuery.setParameter("ages", age);
		return typedQuery.getResultList();
	}

	@Override
	public List<Employee> readByCitycode(int city_code) {
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee where city_code= :code",
				Employee.class);
		typedQuery.setParameter("code", city_code);
		return typedQuery.getResultList();
	}

	@Override
	public List<Employee> readBySalary() {
		TypedQuery<Employee> typedQuery = entityManager.createQuery("from Employee where salary> :sal", Employee.class);
		typedQuery.setParameter("sal", 10000);
		return typedQuery.getResultList();
	}

}
