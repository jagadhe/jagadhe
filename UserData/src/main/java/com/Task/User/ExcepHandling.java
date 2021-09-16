package com.Task.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExcepHandling {
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<Error> ExcepHandle(Throwable t){
		Error error= new Error();
		error.setId(1);
		error.setName(t.getMessage());
		error.setExcep(t);
		error.setEcode("E205");
		 ResponseEntity<Error> r= new ResponseEntity<Error>(error,HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE);
	
		 return r;
	}
	
	@ExceptionHandler(Usernotexisted.class)
	public ResponseEntity<Error> ExcepHandle(Usernotexisted t){
		Error error= new Error();
		error.setId(1);
		error.setName(t.getMessage());
		error.setExcep(t);
		error.setEcode("E206");
		 ResponseEntity<Error> r= new ResponseEntity<Error>(error,HttpStatus.CONFLICT);
	
		 return r;
	}


}
