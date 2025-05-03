package com.tarikinandi.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class RestRootEntity<T> {

    private Integer status;
    private T payload;
    private String errorMessage;


    public  static <T> RestRootEntity<T> ok(T payload){
        RestRootEntity<T> rootEntity = new RestRootEntity<>();
        rootEntity.setStatus(HttpStatus.OK.value());
        rootEntity.setPayload(payload);
        rootEntity.setErrorMessage(null);

        return rootEntity;
    }
}
