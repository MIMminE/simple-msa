package my.project.msa.gatewayservice.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FilterConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r-> r.path("/user-service/**")
                        .filters(f -> f.addRequestHeader("user-request-header", "user-header")
                                .addResponseHeader("user-response", "user-header"))

                        .uri("http://localhost:8001/")
                )
                .build();
    }
}
