package my.project.msa.catalogservice.mapper;

import my.project.msa.catalogservice.dto.response.ResponseCatalog;
import my.project.msa.catalogservice.entity.CatalogEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CatalogsMapper {

    ResponseCatalog toResponseCatalog(CatalogEntity catalogEntity);

    CatalogsMapper INSTANCE = Mappers.getMapper(CatalogsMapper.class);

}