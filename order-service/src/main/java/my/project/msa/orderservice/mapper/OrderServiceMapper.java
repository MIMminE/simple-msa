package my.project.msa.orderservice.mapper;

import my.project.msa.orderservice.dto.OrderDto;
import my.project.msa.orderservice.dto.request.RequestOrder;
import my.project.msa.orderservice.dto.response.ResponseOrder;
import my.project.msa.orderservice.entity.OrderEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.core.annotation.Order;

import java.util.UUID;

@Mapper
public interface OrderServiceMapper {

    OrderEntity toOrderEntity(OrderDto orderDto);
    OrderDto toOrderDto(OrderEntity orderEntity);
    OrderDto toOrderDto(RequestOrder requestOrder);
    ResponseOrder toResponseOrder(OrderDto orderDto);
    ResponseOrder toResponseOrder(OrderEntity orderEntity);


    OrderServiceMapper INSTANCE = Mappers.getMapper(OrderServiceMapper.class);

//    my.project.msa.userservice.entity.UserEntity ToUserEntity(my.project.msa.userservice.dto.UserDto userDto, @Context String password);
//
//    @AfterMapping
//    default void setPassword(my.project.msa.userservice.dto.UserDto userDto, @MappingTarget my.project.msa.userservice.entity.UserEntity userEntity, @Context String password) {
//        userEntity.setUserId(UUID.randomUUID().toString());
//        userEntity.setEncryptedPwd(password);
//
//    }
//
//    my.project.msa.userservice.mapper.UserServiceMapper INSTANCE = Mappers.getMapper(my.project.msa.userservice.mapper.UserServiceMapper.class);
}
