package com.chaimaa.ebankingbackend.dtos;

import com.chaimaa.ebankingbackend.entities.BankAccount;
import com.chaimaa.ebankingbackend.enums.OperationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
public class AccountOperationDTO {

    private Long id;
    private Date operationDate;
    private double amount;

    private OperationType type;
    private String  description;
}
