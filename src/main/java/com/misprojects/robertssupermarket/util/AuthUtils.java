package com.misprojects.robertssupermarket.util;

import com.misprojects.robertssupermarket.model.User;
import com.misprojects.robertssupermarket.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
public class AuthUtils {
    private final UserRepository userRepository;

    public User getLoggedUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username).orElseThrow(EntityNotFoundException::new);
    }
}
