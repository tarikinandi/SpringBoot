package com.tarikinandi.controller;

import com.tarikinandi.dto.CustomerDTO;

public interface ICustomerController {

    public CustomerDTO findCustomerById(Long id);
}
