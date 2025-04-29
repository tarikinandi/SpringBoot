package com.tarikinandi.service;

import com.tarikinandi.DTO.UserDTO;
import com.tarikinandi.jwt.AuthRequest;
import com.tarikinandi.jwt.AuthResponse;

public interface IAuthService {

    public UserDTO register(AuthRequest authRequest);

    public AuthResponse authenticate(AuthRequest authRequest);
}
