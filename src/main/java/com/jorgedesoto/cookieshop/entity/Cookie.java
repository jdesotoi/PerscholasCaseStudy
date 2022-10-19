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
@EqualsAndHashCode(exclude = "cookieImages")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Cookie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    double price;
    String info;
    String detail;
    int quantity;

    public Cookie(String name, double price, String info, String detail, int quantity) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.detail = detail;
        this.quantity = quantity;
    }
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "cookie_cookie_image",
            joinColumns = @JoinColumn(name = "cookie_id"),
            inverseJoinColumns = @JoinColumn(name = "cookie_image_id"))
    private Set<CookieImage> cookieImages = new HashSet<>();
}
