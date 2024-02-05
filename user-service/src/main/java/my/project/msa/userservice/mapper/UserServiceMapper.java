package my.project.msa.userservice.mapper;

import my.project.msa.userservice.dto.UserDto;
import my.project.msa.userservice.entity.UserEntity;
import my.project.msa.userservice.vo.RequestUser;
import my.project.msa.userservice.vo.response.ResponseOrder;
import my.project.msa.userservice.vo.response.ResponseUser;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserServiceMapper {
    UserEntity ToUserEntity(UserDto userDto, @Context String password);

    @AfterMapping
    default void setPassword(UserDto userDto, @MappingTarget UserEntity userEntity, @Context String password) {
        userEntity.setEncryptedPwd(password);
    }
    UserDto toUserDto(UserEntity userEntity, @Context List<ResponseOrder> orders);

    @AfterMapping
    default void setOrders(UserEntity userEntity, @MappingTarget UserDto userDto, @Context List<ResponseOrder> orders) {
        if (orders.isEmpty()) orders = null;
        userDto.setOrders(orders);
    }

    ResponseUser toResponseUser(UserDto userDto);
    UserDto toUserDto(RequestUser requestUser);

    UserServiceMapper INSTANCE = Mappers.getMapper(UserServiceMapper.class);
}