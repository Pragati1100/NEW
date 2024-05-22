package com.charan.service;

import com.charan.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.charan.repo.AdminRepo;
import com.charan.entity.Admin;

import java.util.Optional;

@Service
public class Adminsrvimp implements Adminsrv {
	
	@Autowired
	public AdminRepo admrepo;
	public ResponseEntity<String> registration(Admin admin)
	{

		Optional<Object> user1=Optional.of( admrepo.save(admin));
		if(user1.isPresent())
			return new ResponseEntity<>("successfully registered", HttpStatus.OK);
		else
			return new ResponseEntity<>("failed to registered", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> login(Integer AdminId,String password)
	{
		if(admrepo.findByAdidAndPassword(AdminId,password).isPresent())
			return new ResponseEntity<>("Success", HttpStatus.OK);
		else
			return new ResponseEntity<>("loginfailed", HttpStatus.BAD_REQUEST);
	}
	

}
