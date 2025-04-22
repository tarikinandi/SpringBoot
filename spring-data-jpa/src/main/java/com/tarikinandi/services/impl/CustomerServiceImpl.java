package com.tarikinandi.services.impl;

import com.tarikinandi.dto.AddressDTO;
import com.tarikinandi.dto.CustomerDTO;
import com.tarikinandi.entities.Address;
import com.tarikinandi.entities.Customer;
import com.tarikinandi.repository.AddressRepository;
import com.tarikinandi.repository.CustomerRepository;
import com.tarikinandi.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO findCustomerById(Long id) {
        CustomerDTO customerDTO = new CustomerDTO();
        AddressDTO addressDTO = new AddressDTO();

        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        Customer customer = optional.get();
        Address address = optional.get().getAddress();

        BeanUtils.copyProperties(customer, customerDTO);
        BeanUtils.copyProperties(address, addressDTO);
        customerDTO.setAddress(addressDTO);
        return customerDTO;
    }
}
