package com.olive.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.olive.model.Employee;

@RestController
public class EmployeeRestController {

	@RequestMapping("/data")
	public ResponseEntity<String> showMsg(){

		return new ResponseEntity<String>("Hellow Data", HttpStatus.OK);
	}



	@RequestMapping("/find/{eid}/{ename}/{esal}")
	public ResponseEntity<String> show(@PathVariable Integer eid,
			@PathVariable String ename,
			@PathVariable String esal
			){

		return new ResponseEntity<String>("Hellow Data + EID "+eid + " Ename " + ename
				+" Esal "+esal,
				HttpStatus.OK);

	}


	@RequestMapping("/obj")
	public ResponseEntity<Employee> showObjects(){

		return new ResponseEntity<Employee>(new Employee(10, "Komal", 2020.4), HttpStatus.OK);
	}


	@RequestMapping("/all")
	public ResponseEntity<List<Employee>> all(){

		return new ResponseEntity<List<Employee>>(

				Arrays.asList(new Employee(10, "Komal", 2020.4),
						new Employee(20, "Ravi Kumar", 10.4),
						new Employee(30, "Manoj", 20.4),
						new Employee(40, "Sonam", 300.4)
						)
				, HttpStatus.OK);
	}

	//method of POST Type
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Employee employee){
		
		System.out.println("Producer Call " + employee);
		return new ResponseEntity<String>(employee.toString(), HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateEmp(
			@PathVariable Integer id,
			@RequestBody Employee emp){
		    
		   //updating id as  a sample
		   emp.setEid(id);
		System.out.println("Producer Call For Update Record ::  " + emp);
		return new ResponseEntity<String>(emp.toString(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmp(
			@PathVariable Integer id){
		System.out.println("Producer Call For Delete Record ::  " + id);
		return new ResponseEntity<String>("Deleted Record", HttpStatus.OK);
	}
	
	

}
