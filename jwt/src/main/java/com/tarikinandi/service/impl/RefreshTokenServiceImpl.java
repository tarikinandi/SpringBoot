package com.tarikinandi.service.impl;

import com.tarikinandi.jwt.AuthResponse;
import com.tarikinandi.jwt.JwtService;
import com.tarikinandi.jwt.RefreshTokenRequest;
import com.tarikinandi.model.RefreshToken;
import com.tarikinandi.model.User;
import com.tarikinandi.repository.RefreshTokenRepository;
import com.tarikinandi.service.IRefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenServiceImpl implements IRefreshTokenService {

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private JwtService jwtService;

    public boolean isRefreshTokenExpired(Date expiredDate) {
        return new Date().before(expiredDate);
    }

    public RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setExpireDate(new java.sql.Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 6));
        refreshToken.setUser(user);

        return refreshToken;
    }

    @Override
    public AuthResponse refreshToken(RefreshTokenRequest request) {
        Optional<RefreshToken> byRefreshToken = refreshTokenRepository.findByRefreshToken(request.getRefreshToken());

        if (byRefreshToken.isEmpty()) {
            System.out.println("RefreshToken yok" + request.getRefreshToken());
        }

        RefreshToken refreshToken = byRefreshToken.get();

        if (!isRefreshTokenExpired(refreshToken.getExpireDate())) {
            System.out.println("RefreshToken expire olmuştur : " + request.getRefreshToken());
        }

        String accessToken = jwtService.generateToken(refreshToken.getUser());
        RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(refreshToken.getUser()));

        return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
    }
}
