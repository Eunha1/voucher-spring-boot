package com.spring_boot.voucher.service.inf;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.user.UserRequestDTO;
import com.spring_boot.voucher.model.User;

import java.util.List;

public interface UserService {
    public abstract BaseResponseDTO<List<User>> list();
    public abstract BaseResponseDTO<User> create(UserRequestDTO request);
    public abstract BaseResponseDTO<User> update(UserRequestDTO request, String id);
    public abstract BaseResponseDTO<Boolean> delete(String id);
}
