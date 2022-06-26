package com.chaimaa.ebankingbackend.services;

import com.chaimaa.ebankingbackend.dtos.*;
import com.chaimaa.ebankingbackend.entities.BankAccount;
import com.chaimaa.ebankingbackend.entities.CurrentAccount;
import com.chaimaa.ebankingbackend.entities.Customer;
import com.chaimaa.ebankingbackend.entities.SavingAccount;
import com.chaimaa.ebankingbackend.exceptions.BalanceNotSufficientException;
import com.chaimaa.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.chaimaa.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
  CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
  SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId,double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId,double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource,String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;

  List<BankAccountDTO>bankAccountList();

  CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

  CustomerDTO updateCustomer(CustomerDTO customerDTO);

  void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);


  AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
