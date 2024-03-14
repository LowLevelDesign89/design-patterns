package com.app.rental.controller;

import com.app.rental.models.dto.UserRequestDto;
import com.app.rental.models.entity.Member;
import com.app.rental.services.UserService;

public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public Member createUser(UserRequestDto userRequestDto) {
        return userService.registerNewMember(userRequestDto);
    }
}
