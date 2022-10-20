package com.jorgedesoto.cookieshop.controller;

import com.jorgedesoto.cookieshop.entity.Cookie;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import com.jorgedesoto.cookieshop.repository.UserRepository;
import com.jorgedesoto.cookieshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private CookieRepository cookieRepository;
    private UserService userService;

    @Autowired
    public MainController(CookieRepository cookieRepository, UserService userService) {
        this.cookieRepository = cookieRepository;
        this.userService = userService;
    }

    @GetMapping
    public String home(Model model){
        Iterable<Cookie> cookies = cookieRepository.findFirst3();
        model.addAttribute("cookies",cookies);
//        model.addAttribute("isLogin",userService.isUserLogin());
        return "index";
    }
//    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
