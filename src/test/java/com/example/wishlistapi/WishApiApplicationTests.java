package com.example.wishlistapi;

import com.example.wishlistapi.wish.Wish;
import com.example.wishlistapi.wish.WishRepository;
import com.example.wishlistapi.wish.WishlistApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WishApiApplicationTests {
    @Autowired
    WishRepository wishRepository;

    @Autowired
    WishlistApiService wishlistApiService;

    @Test
    void validScenarioTest() {
        Wish wish = Wish.builder()
                .wish("I wish I had a pen")
                .build();

        Wish wish2 = Wish.builder()
                .wish("I wish I had a pencil")
                .build();

        Wish wish3 = Wish.builder()
                .wish("I wish I had a sharpie")
                .build();


        wishlistApiService.addWish(wish);
        wishlistApiService.addWish(wish2);
        wishlistApiService.addWish(wish3);
        wishlistApiService.deleteWish(2);

        Wish gottenWish = wishlistApiService.getWish(3L);
        List<Wish> gottenWishList = wishlistApiService.getWishList();

        assertNotNull(gottenWish);
        assertNotNull(gottenWishList);
        assertEquals(gottenWish, wish3);
        assertFalse(wishRepository.existsById(2L));
    }
}
