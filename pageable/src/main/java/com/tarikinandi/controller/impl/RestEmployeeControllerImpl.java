package com.tarikinandi.controller.impl;

import com.tarikinandi.controller.IRestEmployeeController;
import com.tarikinandi.dto.EmployeeDTO;
import com.tarikinandi.model.Employee;
import com.tarikinandi.service.IEmployeeService;
import com.tarikinandi.utils.RestPageableEntity;
import com.tarikinandi.utils.RestPageableRequest;
import com.tarikinandi.utils.RestRootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class RestEmployeeControllerImpl extends RestBaseController implements IRestEmployeeController {

    @Autowired
    private IEmployeeService employeeService;


    @GetMapping("/list/pageable")
    @Override
    public RestRootEntity<RestPageableEntity<EmployeeDTO>> findAllPageable(RestPageableRequest pageable) {
        Page<Employee> page = employeeService.findAllPageable(toPageable(pageable));

        RestPageableEntity<EmployeeDTO> pageableResponse = toPageableResponse(page, employeeService.toListDTO(page.getContent()));

        return ok(pageableResponse);
    }
}
