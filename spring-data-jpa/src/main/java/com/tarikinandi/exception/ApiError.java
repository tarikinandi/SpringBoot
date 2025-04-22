package com.tarikinandi.exception;

import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError<T> {

    private String id;

    private Date errorTime;

    private T errors;
}
