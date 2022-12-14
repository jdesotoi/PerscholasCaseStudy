package com.jorgedesoto.cookieshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"users"})
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CookieImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    boolean bite;
    @ManyToMany(mappedBy = "cookieImages")
    private Set<Cookie> cookies = new HashSet<>();
    public CookieImage(String name, boolean bite) {
        this.name = name;
        this.bite = bite;
    }
}
