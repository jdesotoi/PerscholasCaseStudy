package com.jorgedesoto.cookieshop.repository;

import com.jorgedesoto.cookieshop.entity.Cookie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CookieRepository extends CrudRepository<Cookie, Long> {
    @Query(value = "SELECT * FROM cookie LIMIT 3 ", nativeQuery = true)
    Iterable<Cookie> findFirst3();

}
