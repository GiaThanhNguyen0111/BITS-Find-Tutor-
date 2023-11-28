package com.group01.bits.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.group01.bits.locale.Translator;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Date;


public class ResponseStatus implements Serializable {
    private String code;
    @JsonProperty("message")
    private String message;
    @JsonFormat(
            shape = JsonFormat.Shape.STRING,
            pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
    )
    private Date responseTime = new Date();
    @JsonProperty("displayMessage")
    private String displayMessage;

    public ResponseStatus(String code) {
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code, boolean setMessageImplicitly) {
        this.code = code;
        if (setMessageImplicitly) {
            this.message = Translator.toLocale(code);
        }

        this.displayMessage = message;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.setCode(code, true);
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public String getDisplayMessage() {
        return displayMessage;
    }

    public void setDisplayMessage(String displayMessage) {
        this.displayMessage = displayMessage;
    }
}
