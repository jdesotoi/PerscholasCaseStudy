package com.jorgedesoto.cookieshop.controller;

import antlr.ASTNULLType;
import com.jorgedesoto.cookieshop.entity.Cookie;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CookieController {


    @Autowired
    private CookieRepository cookieRepository;
    @GetMapping("/cookies")
    public String cookie(Model model){
        Iterable<Cookie> cookies = cookieRepository.findAll();
        model.addAttribute("cookies",cookies);
        return "cookies";
    }
}
