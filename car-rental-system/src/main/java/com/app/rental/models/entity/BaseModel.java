package com.app.rental.models.entity;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class BaseModel {
    private Long id;
    private ZonedDateTime createdAt;
    private ZonedDateTime lastUpdatedAt;
}
