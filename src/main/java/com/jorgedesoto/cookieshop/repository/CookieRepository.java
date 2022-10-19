package com.jorgedesoto.cookieshop.repository;

import com.jorgedesoto.cookieshop.entity.Cookie;
import org.springframework.data.repository.CrudRepository;

public interface CookieRepository extends CrudRepository<Cookie, Long> {
}
