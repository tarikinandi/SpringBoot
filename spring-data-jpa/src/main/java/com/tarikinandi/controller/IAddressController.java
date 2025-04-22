package com.tarikinandi.controller;

import com.tarikinandi.dto.AddressDTO;

public interface IAddressController {
    public AddressDTO findAddressById(Long id);
}
