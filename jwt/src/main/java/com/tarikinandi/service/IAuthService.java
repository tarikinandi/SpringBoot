package com.tarikinandi.service;

import com.tarikinandi.DTO.UserDTO;
import com.tarikinandi.jwt.AuthRequest;

public interface IAuthService {

    public UserDTO register(AuthRequest authRequest);
}
