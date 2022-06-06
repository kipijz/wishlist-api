package com.example.wishlistapi.controller;

import com.example.wishlistapi.model.Person;
import com.example.wishlistapi.service.AdditionalTaskService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class AdditionalTaskController {
    private final AdditionalTaskService additionalTaskService;

    public AdditionalTaskController(AdditionalTaskService additionalTaskService) {
        this.additionalTaskService = additionalTaskService;
    }

    @PutMapping("additional-task")
    public String getNamesWithDelimiter(@RequestBody Map<String, List<Person>> users) {
        return additionalTaskService.getNamesWithDelimiter(users);
    }
}
