package com.example.saparauthorization.service.Users;

import com.example.saparauthorization.model.User;
import com.example.saparauthorization.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.getUserByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("No user with such email!");
        }

        return JwtUserDetails.build(user);
    }
}
