package com.cgi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cgi.model.Register;
import com.cgi.services.RegisterService;

@RestController
@CrossOrigin("*")
public class RegisterController {
   @Autowired
   RegisterService registerservice;
   @PostMapping("/register")
	public Register addregister(@RequestBody Register r) {
		if(registerservice.saveRegister(r)!=null) {
			return r;
		}
		return null;
	}
	
   @PostMapping("/login")
   public ResponseEntity<?> login(@RequestBody Register register) {
       if (registerservice.validateRegister(register)) {
           return new ResponseEntity<String>("You are logged in successfully", HttpStatus.OK);
       }
       return new ResponseEntity<String>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
   }
}