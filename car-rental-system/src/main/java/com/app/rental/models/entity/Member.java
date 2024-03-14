package com.app.rental.models.entity;

import com.app.rental.models.enums.AccountType;
import lombok.Data;

import java.util.List;

@Data
public class Member extends Account {
    private List<PaymentMethodsMetdata> paymentMethods;

    public Member() {
        super(AccountType.MEMBER);
    }
}
