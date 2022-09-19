package org.codepenguin.labs;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public OpenAPI openAPI() {
        final var title = "codepenguin-lab-pypl-index-data-rest-service";
        final var description = "Spring Boot REST application to return the Pypl Indices Data.";
        final var version = "v1.0.0";
        final var license = "Creative Commons Attribution 3.0 Unported";
        final var licenseFile = "LICENSE.md";
        final var urlPattern = "https://github.com/codepenguin-org/codepenguin-lab-pypl-index-data-rest-service/blob/main/%s";
        final var licenseUrl = urlPattern.formatted(licenseFile);
        final var readmeUrl = urlPattern.formatted(licenseFile);
        return new OpenAPI()
                .info(new Info().title(title).description(description).version(version)
                        .license(new License().name(license).url(licenseUrl)))
                .externalDocs(new ExternalDocumentation().description("README").url(readmeUrl));
    }
}
