package com.filmoteka.v2.backend.service;

import com.filmoteka.v2.backend.model.ApplicationUser;
import com.filmoteka.v2.backend.repository.ApplicationUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private ApplicationUserRepository applicationUserRepository;

    public UserDetailsServiceImpl(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<ApplicationUser> user = Optional.ofNullable(applicationUserRepository.findUserByUsername(username));

        if (user.isPresent()) {
            return new User(user.get().getUsername(), user.get().getPassword(), Collections.emptyList());
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}
