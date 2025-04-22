package com.tarikinandi.controller.impl;

import com.tarikinandi.controller.IHomeController;
import com.tarikinandi.dto.HomeDTO;
import com.tarikinandi.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
public class HomeControllerImpl implements IHomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping("/{id}")
    @Override
    public HomeDTO findHomeById(@PathVariable(name = "id") Long id) {
        return homeService.findHomeById(id);
    }
}
