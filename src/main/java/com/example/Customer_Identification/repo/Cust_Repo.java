package com.example.Customer_Identification.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Customer_Identification.entity.CustomerData;

public interface Cust_Repo extends JpaRepository<CustomerData,String> {

}
