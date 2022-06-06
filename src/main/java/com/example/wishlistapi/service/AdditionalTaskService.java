package com.example.wishlistapi.service;

import com.example.wishlistapi.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdditionalTaskService {
    public String getNamesWithDelimiter(Map<String, List<Person>> person) {
        List<String> personNames = person.values().stream()
                .flatMap(List::stream)
                .map(Person::getName)
                .toList();

        return String.join(",", personNames);
    }
}
