package com.tarikinandi.utils;

import lombok.Data;

import java.util.List;

@Data
public class RestPageableEntity<T> {

    private List<T> content;

    private int pageNumber;

    private int pageSize;

    private Long totalElements;
}
