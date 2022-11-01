package com.jorgedesoto.cookieshop.entity;

import com.jorgedesoto.cookieshop.repository.CookieRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CookieTest {
    private Cookie cookie6;
    private CookieImage cookieImage61;

    @BeforeEach
    void setUp() {
        cookie6 = new Cookie("PLUM BITES", 3.50,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, " +
                        "sit amet fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, sit amet " +
                        "fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                10);
        cookieImage61 = new CookieImage("six.webp", false);
        CookieImage cookieImage62 = new CookieImage("six2.webp", true);
        cookie6.getCookieImages().add(cookieImage61);
        cookie6.getCookieImages().add(cookieImage62);

    }


    @Test
    void removeAllCookieImages() {
        cookie6.removeAllCookieImages();
        assertTrue(cookie6.getCookieImages().isEmpty());
    }

    @Test
    void removeCookieImage() {
        cookie6.removeCookieImage(cookieImage61);
        assertEquals(1, cookie6.getCookieImages().size());
    }
}