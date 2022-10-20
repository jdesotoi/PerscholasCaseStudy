package com.jorgedesoto.cookieshop.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CookieDto {
    String name;
    double price;
    String detail;
    int quantity;
    String imgName;
    boolean biteImg;
    String imgName2;
    boolean biteImg2;
}
