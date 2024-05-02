package com.ynov.evaluation.repositories;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.ynov.evaluation.entities.Student;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@TestMethodOrder(OrderAnnotation.class)
class StudentRepositoryTest {

	@Autowired
	private StudentRepository repos;

	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateStudent() {
		Student savedStudent = repos.save(new Student("Necati ÜNLÜ", 22));
		assertThat(savedStudent.getId()).isGreaterThan(0);
	}
	
	@Test
	@Order(1)
	public void testFindStudentByName() {
		Student product = repos.findByName("Necati ÜNLÜ");
		assertThat(product.getName()).isEqualTo("Necati ÜNLÜ");
	}
	
	@Test
	@Order(3)
	public void testListStudents() {
		List<Student> products = (List<Student>) repos.findAll();
		assertThat(products).size().isGreaterThan(0);
	}
	
	@Test
	@Rollback(true)
	@Order(4)
	public void testUpdateStudent() {
		Student product = repos.findByName("Necati ÜNLÜ");
		product.setAge(23);
		
		repos.save(product);
		
		Student updatedStudent = repos.findByName("Necati ÜNLÜ");
		
		assertThat(updatedStudent.getAge()).isEqualTo(23);
	}
	
	@Test
	@Rollback(false)
	@Order(5)
	public void testDeleteStudent() {
		Student product = repos.findByName("Necati ÜNLÜ");
		
		repos.deleteById(product.getId());
		
		Student deletedStudent = repos.findByName("Necati ÜNLÜ");
		
		assertThat(deletedStudent).isNull();
	}

}
