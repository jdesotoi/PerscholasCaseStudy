package com.jorgedesoto.cookieshop.repository;

import com.jorgedesoto.cookieshop.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByName(String name);
}
