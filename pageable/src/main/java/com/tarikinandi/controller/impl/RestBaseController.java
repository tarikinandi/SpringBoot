package com.tarikinandi.controller.impl;

import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.utils.PagerUtil;
import com.tarikinandi.utils.RestPageableEntity;
import com.tarikinandi.utils.RestPageableRequest;
import com.tarikinandi.utils.RestRootEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestBaseController {

    public Pageable toPageable(RestPageableRequest request){
        return PagerUtil.toPageable(request);
    }

    public <T> RestPageableEntity toPageableResponse(Page<?> pageable, List<T> content){
        return PagerUtil.toPageableResponse(pageable , content);
    }

    public <T> RestRootEntity<T> ok(T payload){
        return RestRootEntity.ok(payload);
    }
}
