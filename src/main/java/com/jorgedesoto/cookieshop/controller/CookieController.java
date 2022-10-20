package com.jorgedesoto.cookieshop.controller;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

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
    /**
     * Get all the cookies and show the view
     */
    @GetMapping("/cookies")
    public String cookie(Model model) {
        Iterable<Cookie> cookies = cookieRepository.findAll();
        model.addAttribute("cookies", cookies);
        return "cookies";
    }
    /**
     * Get one the cookie and show the view
     */
    @GetMapping("/cookies/{id}")
    public String editeCookiesForm(@PathVariable(value = "id") String id, Model model) {
        Cookie cookie = cookieRepository.findById(Long.parseLong(id)).get();
        model.addAttribute("cookie", cookie);
        return "cookie";
    }
    /**
     * Get one the cookie and edit cookie then show all the cookies in the view
     */
    @PostMapping("/cookie/{id}")
    public String editeCookies(@PathVariable(value = "id") String id, Model model,
                               @ModelAttribute("cookieDto") CookieDto cookieDto) {

        Cookie cookie = cookieRepository.findById(Long.parseLong(id)).get();
        cookie.setName(cookieDto.getName());
        cookie.setPrice(cookieDto.getPrice());
        cookie.setDetail(cookieDto.getDetail());
        cookie.setQuantity(cookieDto.getQuantity());

        Set<CookieImage> cImages = cookie.getCookieImages();
        ArrayList<CookieImage> aImages = new ArrayList<>();
        cImages.forEach(img -> {
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


        model.addAttribute("cookie", cookie);
        return "cookie";
    }

    @GetMapping("/deleteCookie/{id}")
    public String deleteCookie(@PathVariable(value = "id") String id, Model model) {

        Cookie cookie = cookieRepository.findById(Long.parseLong(id)).get();
        cookie.removeAllCookieImages();
        cookieRepository.delete(cookie);

        Iterable<Cookie> cookies = cookieRepository.findAll();
        model.addAttribute("cookies", cookies);
        return "cookies";
    }
    @GetMapping("/addCookie")
    public String addCookieForm(){

        return"aadCookie";
    }
    @PostMapping("/addCookies")
    public String addCookie(Model model
                            ,@ModelAttribute("cookieDto") CookieDto cookieDto
    )
    {
        Cookie cookie = new Cookie(cookieDto.getName(), cookieDto.getPrice(), null, cookieDto.getDetail(), cookieDto.getQuantity());
        Cookie sCookie = cookieRepository.save(cookie);
        CookieImage cImage1 = new CookieImage(cookieDto.getImgName(), cookieDto.isBiteImg());
        CookieImage cImage2 = new CookieImage(cookieDto.getImgName2(), cookieDto.isBiteImg2());
        CookieImage scImage1 = cookieImageRepository.save(cImage1);
        CookieImage scImage2 = cookieImageRepository.save(cImage2);
        sCookie.getCookieImages().add(scImage1);
        sCookie.getCookieImages().add(scImage2);
        cookieRepository.save(cookie);

//        Iterable<Cookie> cookies = cookieRepository.findAll();
//        model.addAttribute("cookies", cookies);
        return"redirect:/cookies";
    }


}
