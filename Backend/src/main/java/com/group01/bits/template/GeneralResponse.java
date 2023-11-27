package com.group01.bits.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.group01.bits.exception.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralResponse<T>{
    @JsonProperty("status")
    private ResponseStatus status;
    @JsonProperty("data")
    private T data;

    public GeneralResponse(T data) {
        this.data = data;
    }


    @JsonProperty("status")
    public void setStatus(final ResponseStatus status) {
        this.status = status;
    }

    @JsonProperty("data")
    public void setData(final T data) {
        this.data = data;
    }

    public GeneralResponse success(T data) {
        GeneralResponse res = new GeneralResponse<>();
        res.setStatus(new ResponseStatus("00"));
        res.setData(data);
        return res;
    }

    public GeneralResponse fail(String code) {
        GeneralResponse res = new GeneralResponse<>();
        res.setStatus(new ResponseStatus(code));
        res.setData(null);
        return res;
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
