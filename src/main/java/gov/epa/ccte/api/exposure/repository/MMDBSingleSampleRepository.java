package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.exposure.domain.MMDBSingleSample;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface MMDBSingleSampleRepository extends JpaRepository<MMDBSingleSample, Long> {

    @Transactional(readOnly = true)
    List<MMDBSingleSample> findByDtxsid(String dtxside);

    @Transactional(readOnly = true)
    Page<MMDBSingleSample> findByHarmonizedMediumOrderByIdAsc(String medium, Pageable pageable);

}
