package com.jorgedesoto.cookieshop.controller;

import com.jorgedesoto.cookieshop.entity.Cookie;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private CookieRepository cookieRepository;

    @Autowired
    public MainController(CookieRepository cookieRepository) {
        this.cookieRepository = cookieRepository;
    }

    @GetMapping
    public String home(Model model){
        Iterable<Cookie> cookies = cookieRepository.findFirst3();
        model.addAttribute("cookies",cookies);
        return "index";
    }
//    @PreAuthorize("hasRole('ROLE_USER')")

}