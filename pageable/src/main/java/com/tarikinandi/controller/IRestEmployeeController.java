package com.tarikinandi.controller;

import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.utils.RestPageableEntity;
import com.tarikinandi.utils.RestPageableRequest;
import com.tarikinandi.utils.RestRootEntity;

public interface IRestEmployeeController {

    RestRootEntity<RestPageableEntity<EmployeeDTO>> findAllPageable(RestPageableRequest restPageableRequest);
}
