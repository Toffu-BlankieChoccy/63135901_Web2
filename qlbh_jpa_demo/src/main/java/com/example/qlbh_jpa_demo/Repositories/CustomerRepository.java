package com.example.qlbh_jpa_demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.qlbh_jpa_demo.Models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
