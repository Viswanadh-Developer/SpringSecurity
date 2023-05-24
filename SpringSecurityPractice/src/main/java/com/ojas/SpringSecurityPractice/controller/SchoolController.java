package com.ojas.SpringSecurityPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ojas.SpringSecurityPractice.dao.School;
import com.ojas.SpringSecurityPractice.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	@Autowired
	SchoolService service;
	
	@PostMapping("/schoolDetails")
	public School SchoolDetails(@RequestBody School school) {
		return service.saveSchoolDetails(school); 
	}
	@GetMapping("/testmsg")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public String testMsg() {
		return "Works fine";
	}
	@GetMapping("/testmsgauthorised")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public String testMsgAuth() {
		return "Works fine for me";
	}
}
