package com.oficina.saas.gestao_oficina_backend.controller;

import com.oficina.saas.gestao_oficina_backend.domain.User;
import com.oficina.saas.gestao_oficina_backend.dto.LoginRequest;
import com.oficina.saas.gestao_oficina_backend.dto.LoginResponse;
import com.oficina.saas.gestao_oficina_backend.dto.RegistrationRequest;
import com.oficina.saas.gestao_oficina_backend.service.UserService;
import com.oficina.saas.gestao_oficina_backend.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @Autowired
    public AuthController(UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationRequest request) {
        User newUser = new User();
        newUser.setUsername(request.getUsername());
        newUser.setPassword(request.getPassword());
        newUser.setEmail(request.getEmail());
        userService.save(newUser, request.getRole());
        return new ResponseEntity<>("Usuário cadastrado com sucesso", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        System.out.println("Usuário " + loginRequest.getUsername() + " autenticado com sucesso!");

        // Aqui chamar o gerador de JWT e retornar o token
         String jwt = jwtUtil.generateJwtToken(userDetails);

        LoginResponse response = new LoginResponse();
        response.setToken(jwt);
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getAuthorities().iterator().next().getAuthority()); // Pega a primeira role

        return ResponseEntity.ok(response);

    }
}
