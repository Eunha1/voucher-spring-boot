package com.spring_boot.voucher.service.inf;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.admin.AdminRequestDTO;
import com.spring_boot.voucher.model.Admin;

import java.util.List;

public interface AdminService {
    public abstract BaseResponseDTO<List<Admin>> listAdmin();
    public abstract BaseResponseDTO<Admin> createAdmin(AdminRequestDTO request);
    public abstract BaseResponseDTO<Admin> updateAdmin(AdminRequestDTO request, String id);
    public abstract BaseResponseDTO<Boolean> deleteAdmin(String id);
}
