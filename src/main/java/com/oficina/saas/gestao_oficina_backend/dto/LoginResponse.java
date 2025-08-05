package com.oficina.saas.gestao_oficina_backend.dto;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String username;
    private String role;
}
