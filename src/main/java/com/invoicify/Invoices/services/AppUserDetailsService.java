package com.invoicify.Invoices.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.invoicify.Invoices.models.User;
import com.invoicify.Invoices.repositories.UserRepository;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private UserRepository usersRepository;

    public AppUserDetailsService(UserRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return user;
    }

}