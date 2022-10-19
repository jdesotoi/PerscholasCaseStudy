package com.jorgedesoto.cookieshop;

import com.jorgedesoto.cookieshop.entity.Cookie;
import com.jorgedesoto.cookieshop.entity.CookieImage;
import com.jorgedesoto.cookieshop.repository.CookieImageRepository;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CookieShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(CookieShopApplication.class, args);
    }


}
