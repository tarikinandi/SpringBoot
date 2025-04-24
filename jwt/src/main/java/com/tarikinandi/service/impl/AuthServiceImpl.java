package com.tarikinandi.service.impl;

import com.tarikinandi.DTO.UserDTO;
import com.tarikinandi.jwt.AuthRequest;
import com.tarikinandi.model.User;
import com.tarikinandi.repository.UserRepository;
import com.tarikinandi.service.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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
