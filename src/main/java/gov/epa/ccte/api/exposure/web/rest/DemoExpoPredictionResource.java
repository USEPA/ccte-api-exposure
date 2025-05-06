package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
import gov.epa.ccte.api.exposure.repository.DemoExpoPredictionRepository;
import gov.epa.ccte.api.exposure.web.rest.error.HigherNumberOfDtxsidException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.DemoExpoPrediction}s.
 */
@Tag(name = "Demographic Exposure Prediction Resource",
        description = "API endpoints for demographic prediction in exposure data.")
@SecurityRequirement(name = "api_key")
@Slf4j
@RestController
public class DemoExpoPredictionResource implements DemoExpoPredictionApi{
    private final DemoExpoPredictionRepository repository;

    @Value("200")
    private Integer batchSize;

    public DemoExpoPredictionResource(DemoExpoPredictionRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public List<?> getDemoExpoPredictionByDtxsid(String dtxsid, String projection) {
        log.debug("Fetching assay data for dtxsid = {} with projection = {}", dtxsid, projection);

        if (projection == null || projection.isEmpty()) {
        	List<DemoExpoPrediction> result = repository.findByDtxsid(dtxsid, DemoExpoPrediction.class);
            return result; 
        }

        Object result = switch (projection) {
            case "ccd-demographic" -> repository.findByDtxsid(dtxsid);
            default -> repository.findByDtxsid(dtxsid, DemoExpoPrediction.class);
        };

        if (result instanceof List<?>) {
            return (List<?>) result;
        } else if (result != null) {
            return List.of(result); 
        } else {
            return List.of(); 
        }
    }

    @Override
    public @ResponseBody
    List<DemoExpoPrediction> batchSearchDemoExpoPrediction(String[] dtxsids) {
        log.debug("demographic exposure prediction data for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<DemoExpoPrediction> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, DemoExpoPrediction.class);

        return data;
    }
}
