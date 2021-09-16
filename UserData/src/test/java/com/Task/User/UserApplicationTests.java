package com.Task.User;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.Task.User.User;
import com.Task.User.EmployeeRepoI;
import com.Task.User.EmployeeService;

import static org.mockito.Mockito.when;


@SpringBootTest(classes=UserApplicationTests.class)
class UserApplicationTests {
	@Mock
	private UserRepoI userrepo;
	@InjectMocks
	private UserService userservice = new UserService();

	@Test
	void contextLoads() {
		User e= new User();
		e.setId(1);
		e.setDesignation("tl");
		e.setName("jaga");
		e.setQualification("btech");
		e.setSalary(90000.00);
		User e1= new User();
		e1.setId(2);
		e1.setDesignation("tl");
		e1.setName("deepak");
		e1.setQualification("btech");
		e1.setSalary(80000.00);
		
		
		List<User> list = new ArrayList<User>();
		list.add(e);
		list.add(e1);
		
		
		when(userrepo.findAll()).thenReturn(list);
		
		List<User> usr=userservice.filterusers();
		
		Assertions.assertEquals(1, usr.size());
		
		
	}

}
