package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.FunctionalUse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface FunctionalUseRepository extends JpaRepository<FunctionalUse, Long> {

    @Transactional(readOnly = true)
    
    <T>List<T> findByDtxsid(String dtxsid, Class<T> type);

    <T> List<T> findByDtxsidInOrderByDtxsidAsc(String[] dtxsids, Class<T> type);
}