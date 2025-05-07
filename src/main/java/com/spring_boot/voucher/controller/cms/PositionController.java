package com.spring_boot.voucher.controller.cms;

import com.spring_boot.voucher.dto.BaseResponseDTO;
import com.spring_boot.voucher.dto.position.PositionRequestDTO;
import com.spring_boot.voucher.model.Position;
import com.spring_boot.voucher.service.inf.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin/position")
public class PositionController {

    private final PositionService positionService;

    @GetMapping
    public ResponseEntity<BaseResponseDTO<List<Position>>> list(){
        return ResponseEntity.ok(positionService.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BaseResponseDTO<Position>> detail(@PathVariable String id){
        return ResponseEntity.ok(positionService.detail(id));
    }

    @PostMapping
    public ResponseEntity<BaseResponseDTO<Position>> create(@RequestBody PositionRequestDTO request){
        return ResponseEntity.ok(positionService.create(request));
    }
}
