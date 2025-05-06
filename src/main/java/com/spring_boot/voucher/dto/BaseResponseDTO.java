package com.spring_boot.voucher.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDTO<T> {
    private int code;
    private String message;
    private T data;

    public static <T>ResponseEntity<BaseResponseDTO<T>> success (T data) {
        BaseResponseDTO<T> response = new BaseResponseDTO<>(HttpStatus.OK.value(), "Success", data);
        return ResponseEntity.ok(response);
    }

    public static <T>ResponseEntity<BaseResponseDTO<T>> error (int code, String message) {
        BaseResponseDTO<T> response = new BaseResponseDTO<>(code, message, null);
        return new ResponseEntity<>(response, HttpStatus.valueOf(code));
    }
}
