package com.example.wishlistapi.controller;

import com.example.wishlistapi.model.Wish;
import com.example.wishlistapi.service.WishlistApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WishlistApiController {
    private WishlistApiService wishlistApiService;

    public WishlistApiController(WishlistApiService wishlistApiService) {
        this.wishlistApiService = wishlistApiService;
    }

    @PostMapping("add-wish")
    public void addWish(@RequestBody Wish wish) {
        wishlistApiService.addWish(wish);
    }

    @PutMapping("update-wish/{id}")
    public void updateWish(@PathVariable long id, @RequestBody Wish wish) {
        wishlistApiService.updateWish(wish, id);
    }

    @DeleteMapping("delete-wish/{id}")
    public void deleteWish(@PathVariable long id) {
        wishlistApiService.deleteWish(id);
    }

    @GetMapping("get-wish/{id}")
    public Wish getWish(@PathVariable long id) {
        return wishlistApiService.getWish(id);
    }

    @GetMapping("get-wish-list")
    public List<Wish> getWishList() {
        return wishlistApiService.getWishList();
    }
}
