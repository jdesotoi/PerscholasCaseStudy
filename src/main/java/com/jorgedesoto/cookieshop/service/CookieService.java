package com.jorgedesoto.cookieshop.service;

import com.jorgedesoto.cookieshop.repository.CookieImageRepository;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CookieService {
    private CookieRepository cookieRepository;
    private CookieImageRepository cookieImageRepository;
    @Autowired
    public CookieService(CookieRepository cookieRepository, CookieImageRepository cookieImageRepository) {
        this.cookieRepository = cookieRepository;
        this.cookieImageRepository = cookieImageRepository;
    }


}
