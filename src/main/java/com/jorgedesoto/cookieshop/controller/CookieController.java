package com.jorgedesoto.cookieshop.controller;

import antlr.ASTNULLType;
import com.jorgedesoto.cookieshop.dto.CookieDto;
import com.jorgedesoto.cookieshop.entity.Cookie;
import com.jorgedesoto.cookieshop.entity.CookieImage;
import com.jorgedesoto.cookieshop.repository.CookieImageRepository;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Set;

@Controller
public class CookieController {



    private CookieRepository cookieRepository;
    private CookieImageRepository cookieImageRepository;

    @Autowired
    public CookieController(CookieRepository cookieRepository, CookieImageRepository cookieImageRepository) {
        this.cookieRepository = cookieRepository;
        this.cookieImageRepository = cookieImageRepository;
    }

    @GetMapping("/cookies")
    public String cookie(Model model){
        Iterable<Cookie> cookies = cookieRepository.findAll();
        model.addAttribute("cookies",cookies);
        return "cookies";
    }
    @GetMapping("/cookies/{id}")
    public String editeCookiesForm(@PathVariable(value="id") String id, Model model){
        Cookie cookie = cookieRepository.findById( Long.parseLong(id) ).get();
        model.addAttribute("cookie",cookie);
        return "cookie";
    }
    @PostMapping("/cookie/{id}")
    public String editeCookies(@PathVariable(value="id") String id, Model model,
                               @ModelAttribute("cookieDto")CookieDto cookieDto){

        Cookie cookie = cookieRepository.findById( Long.parseLong(id) ).get();
        cookie.setName(cookieDto.getName());
        cookie.setPrice(cookieDto.getPrice());
        cookie.setDetail(cookieDto.getDetail());
        cookie.setQuantity(cookieDto.getQuantity());

        Set<CookieImage> cImages = cookie.getCookieImages();
        ArrayList<CookieImage> aImages= new ArrayList<>();
        cImages.forEach(img->{
            aImages.add(img);
        });
        CookieImage aImage1 = aImages.get(0);
        CookieImage aImage2 = aImages.get(1);
        aImage1.setName(cookieDto.getImgName());
        aImage1.setBite(cookieDto.isBiteImg());
        aImage2.setName(cookieDto.getImgName2());
        aImage2.setBite(cookieDto.isBiteImg2());
        cookieImageRepository.save(aImage2);
        cookieImageRepository.save(aImage1);
        cookieRepository.save(cookie);


        model.addAttribute("cookie",cookie);
        return "cookie";
    }
    @PostMapping("/deleteCookie/{id}")
    public String deleteCookie(@PathVariable(value="id") String id){
        return"";
    }

}
