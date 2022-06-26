package com.chaimaa.ebankingbackend.web;

import com.chaimaa.ebankingbackend.dtos.AccountHistoryDTO;
import com.chaimaa.ebankingbackend.dtos.AccountOperationDTO;
import com.chaimaa.ebankingbackend.dtos.BankAccountDTO;
import com.chaimaa.ebankingbackend.entities.AccountOperation;
import com.chaimaa.ebankingbackend.entities.BankAccount;
import com.chaimaa.ebankingbackend.exceptions.BankAccountNotFoundException;
import com.chaimaa.ebankingbackend.services.BankAccountService;
import org.apache.catalina.LifecycleState;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService){

        this.bankAccountService=bankAccountService;
    }
    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }
    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }
    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }
    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name = "page",defaultValue = "0") int page ,
            @RequestParam(name = "size", defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId,page,size);
    }


}

