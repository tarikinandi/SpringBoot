package com.tarikinandi.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@UtilityClass
public class PagerUtil {

    public boolean isNullOrEmpty(String val){
        return val == null || val.trim().length() == 0;
    }

    public Pageable toPageable(RestPageableRequest restPageableRequest){

        if(!isNullOrEmpty(restPageableRequest.getColumnName())){
            Sort sortBy = restPageableRequest.isAsc() ? Sort.by(Sort.Direction.ASC , restPageableRequest.getColumnName())
                    : Sort.by(Sort.Direction.DESC , restPageableRequest.getColumnName());
           return PageRequest.of(restPageableRequest.getPageNumber(), restPageableRequest.getPageSize(), sortBy);
        }
        return PageRequest.of(restPageableRequest.getPageNumber(), restPageableRequest.getPageSize());
    }

    public <T> RestPageableEntity toPageableResponse(Page<?> pageable, List<T> content){
        RestPageableEntity<T> restPageableEntity = new RestPageableEntity<>();
        restPageableEntity.setContent(content);
        restPageableEntity.setPageNumber(pageable.getPageable().getPageNumber( ));
        restPageableEntity.setPageSize(pageable.getPageable().getPageSize());
        restPageableEntity.setTotalElements(pageable.getTotalElements());

        return restPageableEntity;
    }
}
