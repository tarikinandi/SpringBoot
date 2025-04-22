package com.tarikinandi.controller.impl;

import com.tarikinandi.controller.IAddressController;
import com.tarikinandi.dto.AddressDTO;
import com.tarikinandi.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressControllerImpl implements IAddressController {

    @Autowired
    private IAddressService addressService;

    @GetMapping("/{id}")
    @Override
    public AddressDTO findAddressById(@PathVariable(name = "id") Long id) {
        return addressService.findAddressById(id);
    }
}
