package com.kedu.study.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kedu.study.dto.DataDTO;
import com.kedu.study.utils.JWTUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/data")
public class DataController {
	
	@Autowired
	private JWTUtil jwt;

	
	@GetMapping
	public ResponseEntity<List<DataDTO>> selectAll(HttpServletRequest request) {
		
		String authHeader = request.getHeader("Authorization");
		String token = authHeader.substring(7);
		boolean result = jwt.validation(token);
		
		if(result){
			List<DataDTO> list = new ArrayList();
			list.add(new DataDTO(1001, "Data1"));
			list.add(new DataDTO(1002, "Data2"));
			list.add(new DataDTO(1003, "Data3"));
			return ResponseEntity.ok(list);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		
		
	}
}
