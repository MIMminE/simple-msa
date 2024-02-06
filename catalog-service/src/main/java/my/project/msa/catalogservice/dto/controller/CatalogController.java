package my.project.msa.catalogservice.dto.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import my.project.msa.catalogservice.dto.response.ResponseCatalog;
import my.project.msa.catalogservice.dto.response.ResponseObject;
import my.project.msa.catalogservice.entity.CatalogEntity;
import my.project.msa.catalogservice.mapper.CatalogsMapper;
import my.project.msa.catalogservice.service.CatalogService;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/catalog-service")
@RequiredArgsConstructor
public class CatalogController {
    final private Environment env;
    final private CatalogService catalogService;
    private CatalogsMapper mapper = CatalogsMapper.INSTANCE;

    @GetMapping("/health_check")
    public String status(HttpServletRequest request){
        return String.format("It's Working in Catalog Service on Port %s", request.getServerPort());
    }

    @GetMapping("/catalogs")
    public ResponseEntity<ResponseObject> getCatalogs(){
        Iterable<CatalogEntity> orderList = catalogService.getAllCatalogs();

        List<ResponseCatalog> result = new ArrayList<>();
        orderList.forEach(v ->
                result.add(mapper.toResponseCatalog(v)));

        ResponseObject response = new ResponseObject(result, result.size());
        return ResponseEntity.ok().body(response);
    }
}
