package com.app.rental.controller;

import com.app.rental.models.dto.SearchRequestDto;
import com.app.rental.models.entity.Vehicle;
import com.app.rental.services.SearchService;

import java.util.List;

public class SearchController {
    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    public List<Vehicle> searchVehicle(SearchRequestDto searchRequestDto) {
        return searchService.retrieveAvailableVehicles(searchRequestDto);
    }
}
