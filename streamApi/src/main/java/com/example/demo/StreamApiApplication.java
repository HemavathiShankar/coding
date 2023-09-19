package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.pojo.Employee;

@SpringBootApplication
public class StreamApiApplication {
	static List<Employee> list = new ArrayList<>();
 static {
	list.add(new Employee("Hema",9000,"HR", List.of("prject1","project2")));
	list.add(new Employee("dhanu",6000,"IT", List.of("prject1","project2")));
	list.add(new Employee("jiya",8000,"HR", List.of("ibm","dell")));
	list.add(new Employee("jiya",7000, "IT",List.of("ibm","dell")));
	list.add(new Employee("alpha",6000,"IT", List.of("prject1","project2")));
	list.add(new Employee("betta",8000,"HR", List.of("ibm","dell")));
	list.add(new Employee("gamma",17000, "IT",List.of("ibm","dell")));
	
	
	
 }

	public static void main(String[] args) {
		//SpringApplication.run(StreamApiApplication.class, args);
		//map
		
		Map<Object, List<Employee>> l1=list.stream().collect(Collectors.groupingBy(emp->emp.getDept()));
		System.out.println(l1);
		for(Object o1:l1.keySet()) {
			Optional<Employee> max=l1.get(o1).stream().max(Comparator.comparing(Employee::getSalary));
			Optional<Employee> min=l1.get(o1).stream().min(Comparator.comparing(Employee::getSalary));
			
			System.out.println("Department "+o1+"maximun "+max+"minimun "+min);
			
		}
		
		
		
		
		
		
		
		
		
		/*
		 * list.stream().map(emp->new
		 * Employee(emp.getName(),emp.getSalary()*10,emp.getDept(),emp.getProjects()))
		 * .forEach(emp->System.out.println(emp));
		 * 
		 * Stream.of(list); //filter
		 * List<Employee>value=list.stream().filter(emp->emp.getName().equalsIgnoreCase(
		 * "jiya")).collect(Collectors.toList()); System.out.println(value);
		 * 
		 * Employee e1=list.stream().map(emp->new
		 * Employee(emp.getName(),emp.getSalary()*10,emp.getDept(),emp.getProjects())).
		 * findFirst().orElse(null);
		 * 
		 * //flatmap //String project= list.stream().flatMap(String ->String :Stream());
		 * List<Employee>e2=list.stream().skip(1).limit(2).collect(Collectors.toList());
		 * System.out.println(e2);
		 * list.stream().sorted((o1,o2)->o1.getName().compareToIgnoreCase(o2.getName()))
		 * .forEach(s->System.out.println(s)); Integer
		 * sum=list.stream().map(emp->emp.getSalary()).reduce(0,Integer::sum);
		 * 
		 * Employee
		 * i1=list.stream().max(Comparator.comparing(Employee::getSalary)).orElseThrow()
		 * ;
		 * 
		 * Employee
		 * emp1=list.stream().sorted((o1,o2)->o2.getSalary()>o1.getSalary()?1:-1).skip(2
		 * ).findFirst().orElseThrow(); System.out.println("third highest salary"+emp1);
		 * List<String>
		 * l1=list.stream().map(Employee::getName).distinct().collect(Collectors.toList(
		 * )); System.out.println(l1); }
		 * 
		 * 
		 * 
		 * }
		 */
}

}