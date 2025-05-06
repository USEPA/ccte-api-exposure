package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import gov.epa.ccte.api.exposure.repository.GenExpoPredictionRepository;
import gov.epa.ccte.api.exposure.web.rest.error.HigherNumberOfDtxsidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class GenExpoPredictionResource implements GenExpoPredictionApi {
    private final GenExpoPredictionRepository repository;

    @Value("200")
    private Integer batchSize;

    public GenExpoPredictionResource(GenExpoPredictionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<?> getGenExpoPredictionByDtxsid(String dtxsid, String projection) {
        log.debug("Fetching assay data for dtxsid = {} with projection = {}", dtxsid, projection);

        if (projection == null || projection.isEmpty()) {
        	List<GenExpoPrediction> result = repository.findByDtxsid(dtxsid, GenExpoPrediction.class);
            return result; 
        }

        Object result = switch (projection) {
            case "ccd-general" -> repository.findByDtxsid(dtxsid);
            default -> repository.findByDtxsid(dtxsid, GenExpoPrediction.class);
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
    List<GenExpoPrediction> batchSearchGenExpoPrediction(String[] dtxsids) {
        log.debug("demographic exposure prediction data for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<GenExpoPrediction> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenExpoPrediction.class);

        return data;
    }
}
