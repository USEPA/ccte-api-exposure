package gov.epa.ccte.api.exposure.web.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * REST controller for getting the {@link ExposureResource}s.
 */
@Tag(name = "Exposure Data Resource",
        description = "API endpoint for checking database connection of exposure application.")
public interface ExposureApi {
    @GetMapping("/exposure/health")
    ResponseEntity health();
}
