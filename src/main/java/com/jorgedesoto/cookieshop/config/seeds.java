package com.jorgedesoto.cookieshop.config;

import com.jorgedesoto.cookieshop.entity.Cookie;
import com.jorgedesoto.cookieshop.entity.CookieImage;
import com.jorgedesoto.cookieshop.entity.Role;
import com.jorgedesoto.cookieshop.entity.User;
import com.jorgedesoto.cookieshop.repository.CookieRepository;
import com.jorgedesoto.cookieshop.repository.RoleRepository;
import com.jorgedesoto.cookieshop.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class seeds {
    @Bean
    CommandLineRunner commandLineRunner(CookieRepository cookieR,
                                        RoleRepository roleR,
                                        UserRepository userR,
                                        PasswordEncoder passwordEncoder) {
        return args -> {

            Cookie cookie1 = new Cookie("JAM & POPPY SEED BITES", 2.50,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, " +
                            "sit amet fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, sit amet " +
                            "fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.", 6);
            CookieImage cookieImage11 = new CookieImage("one.jpg", false);
            CookieImage cookieImage12 = new CookieImage("one2.webp", true);
            cookie1.getCookieImages().add(cookieImage11);
            cookie1.getCookieImages().add(cookieImage12);
            cookieR.save(cookie1);

            Cookie cookie2 = new Cookie("OATMEAL BITES", 3.00,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, " +
                            "sit amet fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, sit amet " +
                            "fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    16);
            CookieImage cookieImage21 = new CookieImage("three.jpg", false);
            CookieImage cookieImage22 = new CookieImage("three2.jpg", true);
            cookie2.getCookieImages().add(cookieImage21);
            cookie2.getCookieImages().add(cookieImage22);
            cookieR.save(cookie2);

            Cookie cookie3 = new Cookie("POPPY SEEDS BITES", 2.00,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, " +
                            "sit amet fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, sit amet " +
                            "fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    5);
            CookieImage cookieImage31 = new CookieImage("two.webp", false);
            CookieImage cookieImage32 = new CookieImage("two2.webp", true);
            cookie3.getCookieImages().add(cookieImage31);
            cookie3.getCookieImages().add(cookieImage32);
            cookieR.save(cookie3);
            Cookie cookie4 = new Cookie("SOFT BUTTER COOKIES", 2.50,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, " +
                            "sit amet fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, sit amet " +
                            "fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    20);
            CookieImage cookieImage41 = new CookieImage("four.webp", false);
            CookieImage cookieImage42 = new CookieImage("four2.webp", true);
            cookie4.getCookieImages().add(cookieImage41);
            cookie4.getCookieImages().add(cookieImage42);
            cookieR.save(cookie4);
            Cookie cookie5 = new Cookie("PARMESAN BITES", 3.50,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, " +
                            "sit amet fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, sit amet " +
                            "fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    9);
            CookieImage cookieImage51 = new CookieImage("five.webp", false);
            CookieImage cookieImage52 = new CookieImage("five2.webp", true);
            cookie5.getCookieImages().add(cookieImage51);
            cookie5.getCookieImages().add(cookieImage52);
            cookieR.save(cookie5);
            Cookie cookie6 = new Cookie("PLUM BITES", 3.50,
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, " +
                            "sit amet fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sagittis elit vitae magna pellentesque, sit amet " +
                            "fermentum tortor malesuada. Nulla facilisi. Ut est nibh, imperdiet non sodales at, eleifend sed urna.",
                    10);
            CookieImage cookieImage61 = new CookieImage("six.webp", false);
            CookieImage cookieImage62 = new CookieImage("six2.webp", true);
            cookie6.getCookieImages().add(cookieImage61);
            cookie6.getCookieImages().add(cookieImage62);
            cookieR.save(cookie6);

            Role roleUser = roleR.save(new Role("ROLE_USER"));
            Role roleAdmin = roleR.save(new Role("ROLE_ADMIN"));

            User admin = new User("jorge.desoto@gmail.com",
                    "jorge",
                    "De Soto",
                    passwordEncoder.encode("123"));
            User user = new User("m@gmail.com",
                    "Maximo",
                    "De Soto",
                    passwordEncoder.encode("123"));

            User u = userR.save(user);
            User a = userR.save(admin);
            u.getRoles().add(roleUser);
            a.getRoles().add(roleUser);
            a.getRoles().add(roleAdmin);
            userR.save(u);
            userR.save(a);
        };
    }
}
