package com.spring_boot.voucher.service.impl;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.auth.AuthResponseDTO;
import com.spring_boot.voucher.dto.auth.LoginRequestDTO;
import com.spring_boot.voucher.exception.HandleException;
import com.spring_boot.voucher.model.Admin;
import com.spring_boot.voucher.repository.AdminRepository;
import com.spring_boot.voucher.security.jwt.JwtUtils;
import com.spring_boot.voucher.service.inf.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AdminRepository adminRepository;
    private final JwtUtils jwtUtils;
    private final PasswordEncoder passwordEncoder;

    @Override
    public BaseResponseDTO<AuthResponseDTO> login(LoginRequestDTO request) {
        Admin admin = adminRepository.findByEmail(request.getEmail()).orElseThrow(() -> new HandleException.CustomThrowException(400, "ACCOUNT_NOT_FOUND"));
        if(!passwordEncoder.matches(request.getPassword(), admin.getPassword())){
            throw new HandleException.CustomThrowException(400, "PASSWORD_INCORRECT");
        }

        String accessToken = jwtUtils.generateToken(admin.getEmail(), admin.getId());

        AuthResponseDTO authResponseDTO = AuthResponseDTO.builder()
                .accessToken(accessToken)
                .id(admin.getId())
                .name(admin.getName())
                .email(admin.getEmail())
                .phone(admin.getPhone())
                .createdAt(admin.getCreatedAt())
                .updatedAt(admin.getUpdatedAt())
                .build();
        return BaseResponseDTO.success(authResponseDTO).getBody();
    }
}
