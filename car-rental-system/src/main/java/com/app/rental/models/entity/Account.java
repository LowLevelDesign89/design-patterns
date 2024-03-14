package com.app.rental.models.entity;

import com.app.rental.models.enums.AccountStatus;
import com.app.rental.models.enums.AccountType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account extends BaseModel{
    private String userName;
    private String password;
    private AccountStatus status;
    private ContactDetails contactDetails;
    private Address address;
    private AccountType accountType;

    public Account(AccountType accountType) {
        this.accountType = accountType;
    }
}
