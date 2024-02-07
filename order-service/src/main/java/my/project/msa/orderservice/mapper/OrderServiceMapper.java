package my.project.msa.orderservice.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface OrderServiceMapper {
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
