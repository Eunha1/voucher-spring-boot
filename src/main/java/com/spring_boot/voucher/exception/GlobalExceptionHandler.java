package com.spring_boot.voucher.exception;

import com.spring_boot.voucher.config.MessageConfig;
import com.spring_boot.voucher.dto.BaseResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HandleException.CustomThrowException.class)
    public ResponseEntity<BaseResponseDTO<Void>> handleCustomThrowException (HandleException.CustomThrowException ex) {
        return BaseResponseDTO.error(ex.getHttpCode(), MessageConfig.getResponseMessage(ex.getMessageCode()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
