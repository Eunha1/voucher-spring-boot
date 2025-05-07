package com.spring_boot.voucher.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AuthResponseDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String accessToken;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
