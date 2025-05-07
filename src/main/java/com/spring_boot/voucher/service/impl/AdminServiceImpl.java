package com.spring_boot.voucher.service.impl;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.admin.AdminRequestDTO;
import com.spring_boot.voucher.exception.HandleException;
import com.spring_boot.voucher.mapper.AdminMapper;
import com.spring_boot.voucher.model.Admin;
import com.spring_boot.voucher.repository.AdminRepository;
import com.spring_boot.voucher.service.inf.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final AdminMapper adminMapper;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public BaseResponseDTO<List<Admin>> listAdmin() {
        List<Admin> admin = adminRepository.findAll();
        return BaseResponseDTO.success(admin).getBody();
    }

    @Override
    public BaseResponseDTO<Admin> createAdmin(AdminRequestDTO request) {
        adminRepository.findByEmail(request.getEmail()).orElseThrow(()-> new HandleException.CustomThrowException(400, "IS_EXIST"));
        Admin admin = adminMapper.toEntity(request);
        admin.setPassword(passwordEncoder.encode(request.getPassword()));
        adminRepository.save(admin);
        return BaseResponseDTO.success(admin).getBody();
    }

    @Override
    public BaseResponseDTO<Admin> updateAdmin(AdminRequestDTO request, String id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new HandleException.CustomThrowException(400, "ACCOUNT_NOT_FOUND "));
        adminMapper.updateAdminFromDto(request, admin);
        adminRepository.save(admin);
        return BaseResponseDTO.success(admin).getBody();
    }

    @Override
    public BaseResponseDTO<Boolean> deleteAdmin(String id) {
        Admin admin = adminRepository.findById(id).orElseThrow(() -> new HandleException.CustomThrowException(400, "ACCOUNT_NOT_FOUND "));
        adminRepository.delete(admin);
        return BaseResponseDTO.success(true).getBody();
    }
}
