package com.chaimaa.ebankingbackend.repositories;

import com.chaimaa.ebankingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
