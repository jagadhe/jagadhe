package com.Task.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	@Autowired
	private UserRepoI erepo;
	
	
	
	public User save(User e) {
		erepo.save(e);
		return e;
		
	}
	public List<User> getall(){
		List<User> users = erepo.findAll();
		return users;
	}
	public Optional<User> getByid(Integer id) {
		Optional<User> e= erepo.findById(id);
		if(e.isPresent()) {
			return e;
		}else {
			throw new Usernotexisted("id not available");
		}
		
	}
	
	public List<User> filetremployees(){
		return erepo.findAll().stream().filetr((e)->{
			return (e.getSalary()+"").startsWith("9");
		}).collect(Collectors.toList());
	}

}
