package com.ojas.SpringSecurityPractice.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
	private int schoolId;
	private String schoolName;
	private String schoolAddress;
}
