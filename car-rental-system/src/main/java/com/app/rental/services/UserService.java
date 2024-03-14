package com.app.rental.services;

import com.app.rental.models.dto.UserRequestDto;
import com.app.rental.models.entity.ContactDetails;
import com.app.rental.models.entity.Member;
import com.app.rental.models.enums.AccountStatus;
import com.app.rental.repository.UserRepository;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Member registerNewMember(UserRequestDto userRequestDto) {
        Member member = new Member();
        member.setAddress(userRequestDto.getAddress());
        member.setStatus(AccountStatus.ACTIVE);
        member.setPassword(userRequestDto.getPassword());
        member.setUserName(userRequestDto.getUsername());
        member.setCreatedAt(ZonedDateTime.now());
        member.setPaymentMethods(new ArrayList<>());
        member.getPaymentMethods().add(userRequestDto.getPaymentMethodsMetdata());
        member.setContactDetails(new ContactDetails());
        member.getContactDetails().setEmailAddress(userRequestDto.getEmailAddress());
        member.getContactDetails().setPhoneNumbers(List.of(userRequestDto.getPhoneNumber()));

        return member;
    }
}
