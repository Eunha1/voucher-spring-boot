package com.spring_boot.voucher.config;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MessageConfig {
    private static MessageSource messageSource;

    public static String getResponseMessage(String messageCode, Object... args){
        return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }
}
