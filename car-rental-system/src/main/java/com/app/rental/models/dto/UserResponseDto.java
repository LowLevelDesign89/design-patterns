package com.app.rental.models.dto;

import com.app.rental.models.entity.ContactDetails;
import lombok.Data;

@Data
public class UserResponseDto {
    private Long userId;
    private String username;
    private ContactDetails contactDetails;
}
