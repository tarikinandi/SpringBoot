package com.tarikinandi.controller.impl;

import com.tarikinandi.DTO.UserDTO;
import com.tarikinandi.controller.IAuthController;
import com.tarikinandi.jwt.AuthRequest;
import com.tarikinandi.service.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements IAuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping("/register")
    @Override
    public UserDTO register(@Valid @RequestBody AuthRequest authRequest) {
        return authService.register(authRequest);
    }
}
