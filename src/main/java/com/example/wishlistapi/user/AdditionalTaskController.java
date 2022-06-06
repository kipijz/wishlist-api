package com.example.wishlistapi.user;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdditionalTaskController {
    private final AdditionalTaskService additionalTaskService;

    public AdditionalTaskController(AdditionalTaskService additionalTaskService) {
        this.additionalTaskService = additionalTaskService;
    }

    @PutMapping("additional-task")
    public String getNamesWithDelimiter(@RequestBody JoinNamesRequest joinNamesRequest) {
        return additionalTaskService.getNamesWithDelimiter(joinNamesRequest);
    }
}
