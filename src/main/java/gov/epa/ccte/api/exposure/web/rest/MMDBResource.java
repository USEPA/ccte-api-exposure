package gov.epa.ccte.api.exposure.web.rest;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RestController;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;
import gov.epa.ccte.api.exposure.domain.MMDBSingleSample;
import gov.epa.ccte.api.exposure.projection.MMDBMediaDescSummary;
import gov.epa.ccte.api.exposure.repository.MMDBAggregateRepository;
import gov.epa.ccte.api.exposure.repository.MMDBMediaDescRepository;
import gov.epa.ccte.api.exposure.repository.MMDBSingleSampleRepository;
import gov.epa.ccte.api.exposure.service.MMDBService;
import gov.epa.ccte.api.exposure.web.rest.requests.MMDBPage;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class MMDBResource implements MMDBApi {

		private final MMDBAggregateRepository aggregateRepository;
		private final MMDBSingleSampleRepository singleSampleRepository;
		private final MMDBMediaDescRepository mediaRepository;
		private final MMDBService mmdbService;

	public MMDBResource(MMDBAggregateRepository aggregateRepository,MMDBSingleSampleRepository singleSampleRepository, MMDBMediaDescRepository mediaRepository, MMDBService mmdbService) {
		this.aggregateRepository = aggregateRepository;
		this.singleSampleRepository = singleSampleRepository;
		this.mediaRepository = mediaRepository;
		this.mmdbService = mmdbService;
	}

	@Override
	public List<MMDBAggregate> getHarmonizedAggregateDataByDtxsid(String dtxsid){
        log.debug("all MMDB harmonized aggregate data for dtxsid = {}", dtxsid);

        return aggregateRepository.findByDtxsid(dtxsid);
       
	}

	@Override
	public MMDBPage getHarmonizedAggregateDataByMedium(String medium, Integer pageNumber){
        log.debug("all MMDB harmonized aggregate data for medium = {}", medium);
        Integer pageSize = 10000;
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return mmdbService.getAllAggregateByMedium(medium, pageSize, pageNumber, pageable);
	}

	@Override
	public List<MMDBSingleSample> getHarmonizedSingleSampleDataByDtxsid(String dtxsid){
        log.debug("all MMDB harmonized single-sample data for dtxsid = {}", dtxsid);

        return singleSampleRepository.findByDtxsid(dtxsid);
	}

	@Override
	public MMDBPage getHarmonizedSingleSampleDataByMedium(String medium, Integer pageNumber){
        log.debug("all MMDB harmonized aggregate data for medium = {}", medium);
        Integer pageSize = 10000;
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        return mmdbService.getAllSingleSampleByMedium(medium, pageSize, pageNumber, pageable);
	}

	public List<MMDBMediaDescSummary> getAllHarmonizedMedia(){
		log.debug("All available media descriptions");
		
		List<MMDBMediaDescSummary> data =  mediaRepository.findBy(MMDBMediaDescSummary.class);
		return data;
	}

}

