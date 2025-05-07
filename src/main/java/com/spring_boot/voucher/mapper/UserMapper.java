package com.spring_boot.voucher.mapper;

import com.spring_boot.voucher.dto.user.UserRequestDTO;
import com.spring_boot.voucher.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    User toEntity(UserRequestDTO dto);

    @Mapping(target = "password", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "adminId", ignore = true)
    void updateUserFromDto(UserRequestDTO dto, @MappingTarget User user);

}
