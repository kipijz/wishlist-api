package com.example.wishlistapi.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalTaskService {
    public String getNamesWithDelimiter(JoinNamesRequest joinNamesRequest) {
        List<String> personNames = joinNamesRequest.getUsers().stream()
                .map(Person::getName)
                .toList();

        return String.join(",", personNames);
    }
}
