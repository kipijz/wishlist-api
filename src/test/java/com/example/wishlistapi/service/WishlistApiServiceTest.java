package com.example.wishlistapi.service;

import com.example.wishlistapi.wish.Wish;
import com.example.wishlistapi.wish.WishRepository;
import com.example.wishlistapi.wish.WishlistApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WishlistApiServiceTest {
    @Mock
    private WishRepository wishRepository;

    @InjectMocks
    private WishlistApiService wishlistApiService;

    private final Wish wish = new Wish(1, "I wish I was a little bit taller.");

    @DisplayName("Should be able to add wish")
    @Test
    void canAddWish() {
        wishlistApiService.addWish(wish);

        ArgumentCaptor<Wish> wishArgumentCaptor =
                ArgumentCaptor.forClass(Wish.class);

        verify(wishRepository)
                .save(wishArgumentCaptor.capture());

        Wish capturedWish = wishArgumentCaptor.getValue();

        assertThat(capturedWish).isEqualTo(wish);
    }

    @DisplayName("Should be able to update wish")
    @Test
    void canUpdateWish() {
        Wish updatedWish = new Wish(1, "I wish a cat.");

        wishlistApiService.addWish(wish);
        Mockito.when(wishRepository.existsById(1L)).thenReturn(true);
        wishlistApiService.updateWish(1, "I wish a cat.");

        ArgumentCaptor<Wish> wishArgumentCaptor =
                ArgumentCaptor.forClass(Wish.class);

        verify(wishRepository, times(2))
                .save(wishArgumentCaptor.capture());

        Wish capturedWish = wishArgumentCaptor.getValue();

        assertThat(capturedWish).isEqualTo(updatedWish);
        assertThat(capturedWish.getId()).isEqualTo(1);
    }

    @DisplayName("Should be able to delete wish")
    @Test
    void canDeleteWish() {
        wishlistApiService.addWish(wish);
        wishlistApiService.deleteWish(1);
        Mockito.when(wishRepository.existsById(1L)).thenReturn(false);

        assertThat(wishRepository.existsById(1L)).isFalse();
    }

    @DisplayName("Should be able to get wish")
    @Test
    void canGetWish() {
        wishlistApiService.addWish(wish);
        Mockito.when(wishRepository.findById(1L)).thenReturn(Optional.of(wish));
        Wish gottenWish = wishlistApiService.getWish(1);

        assertThat(gottenWish).isEqualTo(wish);
    }

    @DisplayName("Should not be able to get wish when id invalid")
    @Test
    void canThrowWhenInvalidId() {
        wishlistApiService.addWish(wish);
        Mockito.when(wishRepository.findById(2L)).thenReturn(Optional.empty());

        ResponseStatusException thrown = assertThrows(
                ResponseStatusException.class,
                () -> wishlistApiService.getWish(2)
        );

        assertTrue(thrown.getMessage().contains("Can't update wish, wish with given ID not found!"));
    }

    @DisplayName("Should be able to get wishlist")
    @Test
    void canGetWishList() {
        wishlistApiService.addWish(wish);
        List<Wish> gottenWishList = wishlistApiService.getWishList();

        assertThat(gottenWishList).isNotNull();
    }
}