package com.spring_boot.voucher.controller.cms;


import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.auth.AuthResponseDTO;
import com.spring_boot.voucher.dto.auth.LoginRequestDTO;
import com.spring_boot.voucher.service.inf.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<BaseResponseDTO<AuthResponseDTO>> login(@RequestBody @Valid LoginRequestDTO request){
        return ResponseEntity.ok(authService.login(request));
    }
}
