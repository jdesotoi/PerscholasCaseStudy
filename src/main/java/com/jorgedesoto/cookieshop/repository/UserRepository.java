package com.jorgedesoto.cookieshop.repository;

import com.jorgedesoto.cookieshop.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @Transactional
    Optional<User> findByEmail(String email);
}
