package gov.epa.ccte.api.exposure.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;



@Configuration
@SecurityScheme(
        type = SecuritySchemeType.APIKEY,
        name = "api_key",
        in = SecuritySchemeIn.HEADER,
        description = "Each API request requires an api_key. Contact the CTX API Admin to request an API Key.",
        paramName = "x-api-key"
)
public class OpenApiConfig {

    private final String apiUrl;
    private final String apiEnvironment;
    private final String appVersion;

    public OpenApiConfig(
            @Value("${application.api-url}") String apiUrl,
            @Value("${application.api-env}") String apiEnvironment,
            @Value("${application.version:unknown}") String appVersion
    ) {
        this.apiUrl = apiUrl;
        this.apiEnvironment = apiEnvironment;
        this.appVersion = appVersion;
    }

    @Bean
    public OpenAPI exposureOpenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Computational Toxicology and Exposure (CTX) APIs - CTX Exposure API")
                        .description("The CTX Exposure API is part of US EPA's Computational Toxicology and Exposure APIs. The CTX Exposure API provides programmtic access to exposure data through a set of endpoints.")
                        .contact(new Contact()
                                .name("")
                                .url("")
                                .email(""))
                        .version(this.appVersion))
                .servers(List.of(new Server().url(this.apiUrl).description(this.apiEnvironment)));
    }
}
