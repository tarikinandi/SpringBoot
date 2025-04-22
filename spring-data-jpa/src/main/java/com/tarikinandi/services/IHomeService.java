package com.tarikinandi.services;


import com.tarikinandi.dto.HomeDTO;

public interface IHomeService {

    public HomeDTO findHomeById(Long id);
}
