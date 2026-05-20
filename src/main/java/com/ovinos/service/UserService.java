package com.ovinos.service;

import com.ovinos.entity.user.User;
import com.ovinos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("Tentando login com: " + email);
        User user = repository.findByEmailIgnoreCase(email)
                .orElseThrow(()-> new UsernameNotFoundException("Usuario não encontrado"));

        System.out.println("Usuário encontrado!");

        return user;
    }
}
