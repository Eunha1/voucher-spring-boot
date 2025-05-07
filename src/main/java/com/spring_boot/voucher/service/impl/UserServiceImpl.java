package com.spring_boot.voucher.service.impl;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.user.UserRequestDTO;
import com.spring_boot.voucher.exception.HandleException;
import com.spring_boot.voucher.mapper.UserMapper;
import com.spring_boot.voucher.model.User;
import com.spring_boot.voucher.repository.UserRepository;
import com.spring_boot.voucher.service.inf.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public BaseResponseDTO<List<User>> list() {
        List<User> user = userRepository.findAll();
        return BaseResponseDTO.success(user).getBody();
    }

    @Override
    public BaseResponseDTO<User> create(UserRequestDTO request) {
        userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new HandleException.CustomThrowException(400, "ACCOUNT_NOT_FOUND"));
        User user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);
        return BaseResponseDTO.success(user).getBody();
    }

    @Override
    public BaseResponseDTO<User> update(UserRequestDTO request, String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new HandleException.CustomThrowException(400, "ACCOUNT_NOT_FOUND"));
        userMapper.updateUserFromDto(request, user);
        userRepository.save(user);
        return BaseResponseDTO.success(user).getBody();
    }

    @Override
    public BaseResponseDTO<Boolean> delete(String id) {
        User user = userRepository.findById(id).orElseThrow(() -> new HandleException.CustomThrowException(400, "ACCOUNT_NOT_FOUND"));
        userRepository.delete(user);
        return BaseResponseDTO.success(true).getBody();
    }
}
