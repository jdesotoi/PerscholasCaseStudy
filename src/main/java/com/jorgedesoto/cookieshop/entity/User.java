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
@EqualsAndHashCode(exclude = {"roles"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String email;
    String fistName;
    String lastName;
    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_image_id"))
    private Set<Role> roles = new HashSet<>();

    String password;

    public User(String email, String fistName, String lastName,  String password) {
        this.email = email;
        this.fistName = fistName;
        this.lastName = lastName;
        this.password = password;
    }
}
