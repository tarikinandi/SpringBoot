package com.tarikinandi.controller;

import com.tarikinandi.DTO.UserDTO;
import com.tarikinandi.jwt.AuthRequest;

public interface IAuthController {

    public UserDTO register(AuthRequest authRequest);
}
