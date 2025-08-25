package gov.epa.ccte.api.exposure.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;
import gov.epa.ccte.api.exposure.domain.MMDBSingleSample;
import gov.epa.ccte.api.exposure.repository.MMDBAggregateRepository;
import gov.epa.ccte.api.exposure.repository.MMDBSingleSampleRepository;
import gov.epa.ccte.api.exposure.web.rest.requests.MMDBPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MMDBService {

    private final MMDBAggregateRepository aggregateRepository;
    private final MMDBSingleSampleRepository singleSampleRepository;

    public MMDBService(MMDBAggregateRepository aggregateRepository, MMDBSingleSampleRepository singleSampleRepository) {
        this.aggregateRepository = aggregateRepository;
        this.singleSampleRepository = singleSampleRepository;
    }
    
    public MMDBPage getAllAggregateByMedium(String medium, Integer pageSize, Integer pageNumber, Pageable pageable) {
        log.debug("medium: " + medium);

        Page<MMDBAggregate> data = aggregateRepository.findByHarmonizedMediumOrderByIdAsc(medium, pageable);
        log.debug("data size: {}", data.getTotalElements());        
        MMDBPage results = MMDBPage.builder()
        	   .medium(medium)
               .data(data.getContent())
               .recordsOnPage(data.getNumberOfElements())
               .totalRecords(data.getTotalElements())
               .pageNumber(pageNumber)
               .totalPages((int) Math.ceil(data.getTotalElements()/pageSize)+1)
               .build();
        return results;
    }
    
    public MMDBPage getAllSingleSampleByMedium(String medium, Integer pageSize, Integer pageNumber, Pageable pageable) {
        log.debug("medium: " + medium);
       
       Page<MMDBSingleSample> data = singleSampleRepository.findByHarmonizedMediumOrderByIdAsc(medium, pageable);
       log.debug("data size: {}", data.getTotalElements());
       MMDBPage results = MMDBPage.builder()
        	   .medium(medium)
               .data(data.getContent())
               .recordsOnPage(data.getNumberOfElements())
               .totalRecords(data.getTotalElements())
               .pageNumber(pageNumber)
               .totalPages((int) Math.ceil(data.getTotalElements()/pageSize)+1)
               .build();
       return results; 
	}

}
