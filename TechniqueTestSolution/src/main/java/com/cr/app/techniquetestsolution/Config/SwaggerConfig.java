package com.cr.app.techniquetestsolution.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI cumOpenAPI(@Value("0.0.1-SNAPSHOT") String appVersion){
        return new OpenAPI()
                .info(new Info()
                        .title("Technique Test Solution")
                        .version(appVersion)
                        .description("Technique Test Solution System")
                );
    }
}
