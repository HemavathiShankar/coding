package com.example.demo.pojo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private String name;
	private Integer salary;
	private String dept;
	private List<String> projects;
}