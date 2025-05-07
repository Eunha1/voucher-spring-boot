package com.spring_boot.voucher.service.inf;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.position.PositionRequestDTO;
import com.spring_boot.voucher.model.Position;

import java.util.List;

public interface PositionService {
    public abstract BaseResponseDTO<List<Position>> list();
    public abstract BaseResponseDTO<Position> detail(String id);
    public abstract BaseResponseDTO<Position> create(PositionRequestDTO request);
    public abstract BaseResponseDTO<Position> update(PositionRequestDTO request, String id);
    public abstract BaseResponseDTO<Boolean> delete(String id);
}
