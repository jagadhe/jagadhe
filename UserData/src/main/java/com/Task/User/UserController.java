package com.Task.User;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService esevr;
	
	
	@PostMapping("save")
	public ResponseEntity<User> saveuser(@RequestBody @Valid User e){
		
		esevr.save(e);
		ResponseEntity<User> rs= new ResponseEntity<User>(e,HttpStatus.CREATED);
		
		return rs;
		
	}
	
	@GetMapping("all")
	public ResponseEntity<List<User>> getAll(){
		
		List<User> getall = esevr.getall();
		
		ResponseEntity<List<User>> rs= new ResponseEntity<List<User>>(getall,HttpStatus.OK);
		return rs;
		
		
	}
	
	@GetMapping("getbyid/{id}")
	public ResponseEntity<Optional<User>> getById(@PathVariable("id") Integer id){
		
		Optional<User> user = esevr.getByid(id);
	
		ResponseEntity<Optional<User>> rs = new ResponseEntity<Optional<User>>(user,HttpStatus.OK);
		return rs;
		
	}

}
