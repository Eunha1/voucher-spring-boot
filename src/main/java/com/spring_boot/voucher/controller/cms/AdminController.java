package com.spring_boot.voucher.controller.cms;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.admin.AdminRequestDTO;
import com.spring_boot.voucher.model.Admin;
import com.spring_boot.voucher.service.inf.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/admin-account")
public class AdminController {
    private final AdminService adminService;

    @GetMapping
    public ResponseEntity<BaseResponseDTO<List<Admin>>> listAdmin(){
        return ResponseEntity.ok(adminService.listAdmin());
    }

    @PostMapping
    public ResponseEntity<BaseResponseDTO<Admin>> createAdmin(@RequestBody AdminRequestDTO request){
        return ResponseEntity.ok(adminService.createAdmin(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<Admin>> updateAdmin(@RequestBody AdminRequestDTO request, @PathVariable String id){
        return ResponseEntity.ok(adminService.updateAdmin(request, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<Boolean>> deleteAdmin(@PathVariable String id){
        return ResponseEntity.ok(adminService.deleteAdmin(id));
    }
}
