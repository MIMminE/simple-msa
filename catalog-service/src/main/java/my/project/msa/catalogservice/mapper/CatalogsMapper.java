package my.project.msa.catalogservice.mapper;

import my.project.msa.catalogservice.dto.response.ResponseCatalog;
import my.project.msa.catalogservice.entity.CatalogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogsMapper {


    ResponseCatalog toResponseCatalog(CatalogEntity catalogEntity);

    CatalogsMapper INSTANCE = Mappers.getMapper(CatalogsMapper.class);

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