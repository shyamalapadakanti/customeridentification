package com.example.Customer_Identification.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer_Identification.entity.CustomerData;
import com.example.Customer_Identification.repo.Cust_Repo;


@CrossOrigin("http://localhost:3000")

@RestController
public class Cust_Controller {
	@Autowired
	Cust_Repo custRepo;
	

	
	
	
	@GetMapping("/api/getcustomers")
	public ResponseEntity<List<CustomerData>>getStudents(){
		return new ResponseEntity<>(custRepo.findAll(),HttpStatus.OK);
	}
	
	
	@GetMapping("/api/getcustomers/{id}")
	public ResponseEntity<CustomerData>getCustomers(@PathVariable String id){
		Optional<CustomerData> cust = custRepo.findById(id);
		if(cust.isPresent()) {
			return new ResponseEntity<>(cust.get(),HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/api/savecustomerslist")
	public ResponseEntity<CustomerData> saveCustomer(@RequestBody CustomerData cust){
		return new ResponseEntity<>(custRepo.save(cust),HttpStatus.CREATED);
	}
	
	@PutMapping("/api/updatecustomerslist/{id}")
	public ResponseEntity<CustomerData>updateStudent(@PathVariable String id,@RequestBody CustomerData cust)
		{
			Optional<CustomerData> customer = custRepo.findById(id);
			if(customer.isPresent()) {
			customer.get().setCustomer_Name(cust.getCustomer_Name());
			
			return new ResponseEntity<>(custRepo.save(customer.get()),HttpStatus.OK);
			
		}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			}
	
	
	@DeleteMapping("/api/deletecustomerslist/{id}")
	public ResponseEntity<CustomerData>deleteCustomer(@PathVariable String id){
		Optional<CustomerData> cust = custRepo.findById(id);
		if(cust.isPresent()) {
			custRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	
	

}
