package com.chaimaa.ebankingbackend.repositories;

import com.chaimaa.ebankingbackend.entities.BankAccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
}
