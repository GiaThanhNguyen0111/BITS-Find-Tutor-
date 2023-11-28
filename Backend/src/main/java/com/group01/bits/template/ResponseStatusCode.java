package com.group01.bits.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.group01.bits.exception.ResponseStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatusCode;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class ResponseStatusCode extends HttpEntity {
    @JsonProperty("code")
    private String code;
    @JsonProperty("httpCode")
    private HttpStatusCode httpCode;
}
