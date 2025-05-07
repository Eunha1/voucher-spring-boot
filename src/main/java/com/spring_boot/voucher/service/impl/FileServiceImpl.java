package com.spring_boot.voucher.service.impl;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.file.FileResponseDTO;
import com.spring_boot.voucher.service.inf.FileService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public BaseResponseDTO<FileResponseDTO> uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String uploadDirs = "uploads/";

        String originalFileName = file.getOriginalFilename();
        String timestamp = String.valueOf(System.currentTimeMillis());

        assert originalFileName != null;
        String fileNameWithoutExt = originalFileName.substring(0, originalFileName.lastIndexOf('.'));
        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));

        String newFileName = fileNameWithoutExt + "_" + timestamp + extension;

        Path path = Paths.get(uploadDirs + newFileName);

        String relativePath = path.toString().replace('\\', '/');

        Files.createDirectories(path.getParent());
        Files.write(path, file.getBytes());

        String baseUrl = request.getRequestURL().toString().replace(request.getRequestURI(), "");

        FileResponseDTO fileResponseDTO = FileResponseDTO.builder()
                .name(originalFileName)
                .path(relativePath)
                .url(baseUrl + "/" + relativePath)
                .build();
        return BaseResponseDTO.success(fileResponseDTO).getBody();
    }
}
