package com.tarikinandi.service;

import com.tarikinandi.jwt.AuthResponse;
import com.tarikinandi.jwt.RefreshTokenRequest;
import com.tarikinandi.model.RefreshToken;
import com.tarikinandi.model.User;

public interface IRefreshTokenService {

    public AuthResponse refreshToken(RefreshTokenRequest request);
    public RefreshToken createRefreshToken(User user);
}
