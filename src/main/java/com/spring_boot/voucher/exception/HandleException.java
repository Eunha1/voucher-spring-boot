package com.spring_boot.voucher.exception;

public class HandleException {
    public static class CustomThrowException extends BaseException{
        public CustomThrowException(int httpCode, String messageCode){
            super(messageCode, httpCode);
        }
    }
}
