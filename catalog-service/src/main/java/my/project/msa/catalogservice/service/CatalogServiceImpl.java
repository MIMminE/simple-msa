package my.project.msa.catalogservice.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import my.project.msa.catalogservice.entity.CatalogEntity;
import my.project.msa.catalogservice.entity.CatalogRepository;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class CatalogServiceImpl implements CatalogService{

    CatalogRepository repository;
    Environment env;

    @Override
    public Iterable<CatalogEntity> getAllCatalogs() {
        return repository.findAll();
    }
}
