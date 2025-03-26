package com.kedu.study.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.LoginDTO;
import com.kedu.study.utils.JWTUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private JWTUtil jwt;
	
	@PostMapping("/login") //컨벤션에 의해 무슨 기능인지를 붙여준다. 
	public ResponseEntity<String> login(@RequestBody LoginDTO dto){
		//System.out.println(dto.getId() +" : "+ dto.getPw());
		
		// DB 조회코드...
		if(true) {
			String token = jwt.createToken(dto.getId());
			//System.out.println(token);
			return ResponseEntity.ok(token);
		}
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
	}
	
	@DeleteMapping("/logout")
	public ResponseEntity<String> logout(){
		
		return ResponseEntity.ok().build();
	}
	
	
	public void a() {
		System.out.println("a");
	}
	
	
}
