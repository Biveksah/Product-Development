package com.example.productdevelopment.Config;

import com.example.productdevelopment.Entity.User;
import com.example.productdevelopment.Service.UserServices;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetailsServices implements UserDetailsService {

    private UserServices userServices;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userServices.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User
                (user.getEmail(),
                        user.getPassword(),
                         true,
                        true,
                        true,
                        true,
                        AuthorityUtils.createAuthorityList("ROLE_USER"));
    }
}

