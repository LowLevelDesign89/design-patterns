package com.app.rental.models.entity;

import com.app.rental.models.enums.AccountType;
import lombok.Data;

@Data
public class Admin extends Account {
    private Long storeId;

    public Admin() {
        super(AccountType.ADMIN);
    }
}
