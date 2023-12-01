package com.group01.bits.exception;

import com.group01.bits.template.GeneralResponse;
import com.group01.bits.template.ResponseStatusCode;
import lombok.Getter;

import java.util.Map;
import java.util.Objects;

@Getter
public class BaseResponseException extends RuntimeException{
    private final ResponseStatusCode responseStatusCode;
    private GeneralResponse dataResponse;

    private Map<String, String> params;

    public BaseResponseException(ResponseStatusCode responseStatus) {
        this.responseStatusCode = responseStatus;
    }

    public BaseResponseException(GeneralResponse dataResponse, ResponseStatusCode responseStatus) {
        this.dataResponse = dataResponse;
        this.responseStatusCode = responseStatus;
    }

    public BaseResponseException(GeneralResponse dataResponse, ResponseStatusCode responseStatus, Map<String, String> params) {
        this.dataResponse = dataResponse;
        this.responseStatusCode = responseStatus;
        this.params = params;
    }

    public BaseResponseException(String message, Throwable cause, ResponseStatusCode responseStatus) {
        super(message, cause);
        this.responseStatusCode = responseStatus;
    }

    public BaseResponseException() {

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseResponseException that = (BaseResponseException) o;
        return Objects.equals(responseStatusCode, that.responseStatusCode) && Objects.equals(dataResponse, that.dataResponse) && Objects.equals(params, that.params);
    }

    @Override
    public int hashCode() {
        return Objects.hash(responseStatusCode, dataResponse, params);
    }

}
