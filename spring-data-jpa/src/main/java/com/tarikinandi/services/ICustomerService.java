package com.tarikinandi.services;

import com.tarikinandi.dto.CustomerDTO;

public interface ICustomerService {

    public CustomerDTO findCustomerById(Long id);
}
