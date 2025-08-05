package com.oficina.saas.gestao_oficina_backend.service;

import com.oficina.saas.gestao_oficina_backend.domain.User;
import com.oficina.saas.gestao_oficina_backend.domain.UserRole;
import com.oficina.saas.gestao_oficina_backend.exception.EmailAlreadyExistsException;
import com.oficina.saas.gestao_oficina_backend.exception.UsernameAlreadyExistsException;
import com.oficina.saas.gestao_oficina_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User save(User user, UserRole role) {

        if (userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Nome de usuário já existe.");
        }

        if (userRepository.existsByEmail(user.getEmail())) {
            throw  new EmailAlreadyExistsException("E-mail já está cadastrado.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(role);
        user.setEnabled(true);
        return userRepository.save(user);
    }

}
