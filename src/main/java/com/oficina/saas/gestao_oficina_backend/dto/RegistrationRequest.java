package com.oficina.saas.gestao_oficina_backend.dto;

import com.oficina.saas.gestao_oficina_backend.domain.UserRole;
import lombok.Data;

@Data
public class RegistrationRequest {
    private String username;
    private String password;
    private String email;
    private UserRole role;
}
