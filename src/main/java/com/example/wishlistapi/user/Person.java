package com.example.wishlistapi.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    private long id;

    private String type;
    private String name;
    private String email;
}
