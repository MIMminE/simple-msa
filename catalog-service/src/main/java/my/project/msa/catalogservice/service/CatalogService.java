package my.project.msa.catalogservice.service;

import my.project.msa.catalogservice.entity.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
