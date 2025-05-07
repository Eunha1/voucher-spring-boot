package com.spring_boot.voucher.controller.cms;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.file.FileResponseDTO;
import com.spring_boot.voucher.service.inf.FileService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/upload")
public class FileController {

    private final FileService fileService;

    public ResponseEntity<BaseResponseDTO<FileResponseDTO>> uploadFile(@RequestParam("file")MultipartFile file, HttpServletRequest request) throws IOException{
        return ResponseEntity.ok(fileService.uploadFile(file, request));
    }
}
