package com.ojas.SpringSecurityPractice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ojas.SpringSecurityPractice.dao.School;

@Service
public class SchoolService {

	public School saveSchoolDetails(School school) {		
		return school;
	}
	
}
