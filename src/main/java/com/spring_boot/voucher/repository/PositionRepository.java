package com.spring_boot.voucher.repository;

import com.spring_boot.voucher.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, String> {
}
