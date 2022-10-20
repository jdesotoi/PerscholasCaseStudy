package com.jorgedesoto.cookieshop.controller;

import com.jorgedesoto.cookieshop.entity.Cookie;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ShopControllers {
    private CookieRepository cookieRepository;

    @Autowired
    public ShopControllers(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }
//    @PreAuthorize("has  Role('ROLE_USER')")
    @GetMapping("/shop")
    public  String shop(Model model){
        Iterable<Cookie> cookies = cookieRepository.findAll();
        model.addAttribute("cookies",cookies);
        return "shop";
    }
    @GetMapping("/shop/cookie/{id}")
    public String shopCookie(@PathVariable(value="id") String id, Model model){
        Cookie cookie = cookieRepository.findById( Long.parseLong(id) ).get();
        model.addAttribute("cookie",cookie);
        return "item";
    }
}
