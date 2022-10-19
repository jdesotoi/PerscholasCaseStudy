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
    int price;
    String info;
    String detail;
    int quantity;

    public Cookie(String name, int price, String info, String detail, int quantity) {
        this.name = name;
        this.price = price;
        this.info = info;
        this.detail = detail;
        this.quantity = quantity;
    }
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "app_user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private Set<CookieImage> cookieImages = new HashSet<>();
}
