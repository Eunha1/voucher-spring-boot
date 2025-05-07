package com.spring_boot.voucher.service.inf;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.auth.AuthResponseDTO;
import com.spring_boot.voucher.dto.auth.LoginRequestDTO;

public interface AuthService {
    public abstract BaseResponseDTO<AuthResponseDTO> login(LoginRequestDTO request);
}
