package com.tarikinandi.controller;

import com.tarikinandi.dto.HomeDTO;

public interface IHomeController {

    public HomeDTO findHomeById(Long id);
}
