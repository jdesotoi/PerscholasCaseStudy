package com.jorgedesoto.cookieshop.service;

import com.jorgedesoto.cookieshop.entity.SecurityUser;
import com.jorgedesoto.cookieshop.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return  userRepository.findByEmail(email)
                .map(SecurityUser::new).orElseThrow(()->new UsernameNotFoundException("Email not found: "+ email));
    }
}
