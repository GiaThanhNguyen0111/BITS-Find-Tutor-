package com.group01.bits.exception.handler;

import com.group01.bits.exception.BaseResponseException;
import com.group01.bits.template.GeneralResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler({BaseResponseException.class})
    public GeneralResponse handleException(BaseResponseException ex) {

        return new GeneralResponse<>().fail(ex.getResponseStatusCode().getCode());
    }
}
