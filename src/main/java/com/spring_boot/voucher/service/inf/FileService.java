package com.spring_boot.voucher.service.inf;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.file.FileResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    public abstract BaseResponseDTO<FileResponseDTO> uploadFile (MultipartFile file, HttpServletRequest request) throws IOException;
}
