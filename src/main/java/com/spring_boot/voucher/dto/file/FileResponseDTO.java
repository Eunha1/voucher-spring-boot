package com.spring_boot.voucher.dto.file;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FileResponseDTO {
    private String name;
    private String path;
    private String url;
}
