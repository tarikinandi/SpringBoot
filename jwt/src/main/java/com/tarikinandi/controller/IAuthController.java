package com.tarikinandi.controller;

import com.tarikinandi.DTO.UserDTO;
import com.tarikinandi.jwt.AuthRequest;
import com.tarikinandi.jwt.AuthResponse;
import com.tarikinandi.jwt.RefreshTokenRequest;

public interface IAuthController {

    public UserDTO register(AuthRequest authRequest);

    public AuthResponse authenticate(AuthRequest authRequest);

    public AuthResponse refreshToken(RefreshTokenRequest request);

}
