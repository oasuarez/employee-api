package com.crud.employee;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.crud.employee.model.Employee;
import com.crud.employee.repository.EmployeeRepository;
import com.crud.employee.service.impl.EmployeeServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class EmployeeApplicationTests {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private EmployeeServiceImpl empService = new EmployeeServiceImpl();

	@Autowired
	EmployeeRepository eRepo;

	@Test
	@Order(1)
	public void testCreate () {
		Employee e = new Employee();
		e.setId(1);
		e.setName("Orlando Suarez");
		e.setEmail("orlando.suarez@unosquare.com");
		e.setOffice("100a");
		e.setPhone("3173417692");
		e.setRole("developer");
		eRepo.save(e);
		assertNotNull(eRepo.findById(1).get());
	}

	@Test
	@Order(2)
	public void testReadAll () {
		List<Employee> list = eRepo.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	public void testRead () {
		Employee product = eRepo.findById(1).get();
		assertEquals("Orlando Suarez", product.getName());
	}

	@Test
	@Order(4)
	public void testUpdate () {
		Employee e = eRepo.findById(1).get();
		e.setOffice("100b");
		eRepo.save(e);
		assertNotEquals("100a", eRepo.findById(1).get().getOffice());
	}

	@Test
	@Order(5)
	public void testDelete () {
		eRepo.deleteById(1);
		assertThat(eRepo.existsById(1)).isFalse();
	}

}
