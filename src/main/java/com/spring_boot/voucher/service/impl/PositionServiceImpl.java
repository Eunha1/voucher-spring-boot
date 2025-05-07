package com.spring_boot.voucher.service.impl;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.position.PositionRequestDTO;
import com.spring_boot.voucher.exception.HandleException;
import com.spring_boot.voucher.model.Position;
import com.spring_boot.voucher.repository.PositionRepository;
import com.spring_boot.voucher.service.inf.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public BaseResponseDTO<List<Position>> list() {
        List<Position> listPosition = positionRepository.findAll();
        return BaseResponseDTO.success(listPosition).getBody();
    }

    @Override
    public BaseResponseDTO<Position> detail(String id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new HandleException.CustomThrowException(400, "NOT_FOUND"));
        return BaseResponseDTO.success(position).getBody();
    }

    @Override
    public BaseResponseDTO<Position> create(PositionRequestDTO request) {
        Position position = Position.builder()
                .name(request.getName())
                .build();
        positionRepository.save(position);
        return BaseResponseDTO.success(position).getBody();
    }

    @Override
    public BaseResponseDTO<Position> update(PositionRequestDTO request, String id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new HandleException.CustomThrowException(400, "NOT_FOUND"));
        position.setName(request.getName());
        positionRepository.save(position);
        return BaseResponseDTO.success(position).getBody();
    }

    @Override
    public BaseResponseDTO<Boolean> delete(String id) {
        Position position = positionRepository.findById(id).orElseThrow(() -> new HandleException.CustomThrowException(400, "NOT_FOUND"));
        positionRepository.delete(position);
        return BaseResponseDTO.success(true).getBody();
    }
}
