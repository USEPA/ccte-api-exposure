package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.FunctionalUseCategory;
import gov.epa.ccte.api.exposure.projection.QsurDataAll;
import gov.epa.ccte.api.exposure.domain.FunctionalUse;
import gov.epa.ccte.api.exposure.repository.FunctionalUseCategoryRepository;
import gov.epa.ccte.api.exposure.repository.FunctionalUseRepository;
import gov.epa.ccte.api.exposure.repository.QsurDataRepository;
import gov.epa.ccte.api.exposure.web.rest.error.HigherNumberOfDtxsidException;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class FunctionalUseResource implements FunctionalUseApi {

        private final FunctionalUseRepository repository;
        private final FunctionalUseCategoryRepository categoryRepository;
        private final QsurDataRepository qsurDataRepository;
        
        @Value("200")
        private Integer batchSize;

    public FunctionalUseResource(FunctionalUseRepository repository, FunctionalUseCategoryRepository categoryRepository, QsurDataRepository qsurDataRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.qsurDataRepository = qsurDataRepository;
    }

    @Override
    public List<FunctionalUse> getFunctionalUseByDtxsid(String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

        List<FunctionalUse> data = repository.findByDtxsid(dtxsid, FunctionalUse.class);

        return data;
    }

    @Override
    public List<FunctionalUseCategory> getFunctionalUseCategory(){
        log.debug("all functional use category");
        List<FunctionalUseCategory> data = categoryRepository.findAll();
        return data;
    }

    @Override
    public List<QsurDataAll> getFunctionalUseProbabilityByDtxsid(String dtxsid) {
        log.debug("all functional use probability for dtxsid = {}", dtxsid);

        List<QsurDataAll> data = qsurDataRepository.findByDtxsidOrderByHarmonizedFunctionalUseAsc(dtxsid, QsurDataAll.class);

        return data;
    }
    
    @Override
    public @ResponseBody
    List<FunctionalUse>batchSearchFunctionalUse(String[] dtxsids) {
        log.debug("functional use data for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<FunctionalUse> data = repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, FunctionalUse.class);

        return data;
    }
}
