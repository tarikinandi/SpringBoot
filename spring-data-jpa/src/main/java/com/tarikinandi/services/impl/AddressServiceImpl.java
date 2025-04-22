package com.tarikinandi.services.impl;

import com.tarikinandi.dto.AddressDTO;
import com.tarikinandi.dto.CustomerDTO;
import com.tarikinandi.entities.Address;
import com.tarikinandi.entities.Customer;
import com.tarikinandi.repository.AddressRepository;
import com.tarikinandi.services.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements IAddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public AddressDTO findAddressById(Long id) {
        AddressDTO addressDTO = new AddressDTO();
        CustomerDTO customerDTO = new CustomerDTO();

        Optional<Address> optional = addressRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        Address address = optional.get();
        Customer customer = optional.get().getCustomer();

        BeanUtils.copyProperties(address, addressDTO);
        BeanUtils.copyProperties(customer, customerDTO);
        addressDTO.setCustomer(customerDTO);
        return addressDTO;
    }
}
