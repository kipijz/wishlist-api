package com.example.wishlistapi.service;

import com.example.wishlistapi.model.Wish;
import com.example.wishlistapi.repository.WishRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class WishlistApiService {
    private final WishRepository wishRepository;

    public WishlistApiService(WishRepository wishRepository) {
        this.wishRepository = wishRepository;
    }

    public void addWish(Wish wish) {
        wishRepository.save(wish);
    }

    public void updateWish(Wish wish, long id) {
        if (wishRepository.existsById(id)) {
            wish.setId(id);
            wishRepository.save(wish);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't update wish, wish with given ID not found!");
        }
    }

    public void deleteWish(long id) {
        wishRepository.deleteById(id);
    }

    public Wish getWish(long id) {
        return wishRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't update wish, wish with given ID not found!"));
    }

    public List<Wish> getWishList() {
        return wishRepository.findAll();
    }
}