package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface MMDBAggregateRepository extends JpaRepository<MMDBAggregate, Long> {

    @Transactional(readOnly = true)
    List<MMDBAggregate> findByDtxsid(String dtxsid);
    
    @Transactional(readOnly = true)
    Page<MMDBAggregate> findByHarmonizedMediumOrderByIdAsc(String medium, Pageable pageable);
}
