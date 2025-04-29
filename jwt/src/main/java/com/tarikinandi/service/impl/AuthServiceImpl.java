package com.tarikinandi.service.impl;

import com.tarikinandi.DTO.UserDTO;
import com.tarikinandi.jwt.AuthRequest;
import com.tarikinandi.jwt.AuthResponse;
import com.tarikinandi.jwt.JwtService;
import com.tarikinandi.model.RefreshToken;
import com.tarikinandi.model.User;
import com.tarikinandi.repository.RefreshTokenRepository;
import com.tarikinandi.repository.UserRepository;
import com.tarikinandi.service.IAuthService;
import com.tarikinandi.service.IRefreshTokenService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider  authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    @Autowired
    private IRefreshTokenService refreshTokenService;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        try {
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
            authenticationProvider.authenticate(auth);

            Optional<User> optionalUser = userRepository.findByUsername(authRequest.getUsername());
            String accessToken = jwtService.generateToken(optionalUser.get());

            RefreshToken refreshToken = refreshTokenService.createRefreshToken(optionalUser.get());
            refreshTokenRepository.save(refreshToken);


            return new AuthResponse(accessToken, refreshToken.getRefreshToken());
        } catch (Exception e) {
            System.out.println("Kullanıcı adı veya şifre hatalı");
        }
        return null;

    }

    @Override
    public UserDTO register(AuthRequest authRequest) {
        User user = new User();
        UserDTO userDTO = new UserDTO();

        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));

        User savedUser = userRepository.save(user);
        BeanUtils.copyProperties(savedUser, userDTO);
        return userDTO;
    }


}
