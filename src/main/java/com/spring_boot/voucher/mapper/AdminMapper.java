package com.spring_boot.voucher.mapper;

import com.spring_boot.voucher.dto.admin.AdminRequestDTO;
import com.spring_boot.voucher.model.Admin;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdminMapper {
    AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mapping(target = "password", ignore = true)
    Admin toEntity(AdminRequestDTO dto);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "role", ignore = true)
    void updateAdminFromDto(AdminRequestDTO dto, @MappingTarget Admin admin);
}
