package com.example.firststep_server.domain.auth.presentation.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class SignupRequest {

    @NotBlank
    private String userName;

    @NotBlank
    private String accountId;

    @NotBlank
    private String password;
}
