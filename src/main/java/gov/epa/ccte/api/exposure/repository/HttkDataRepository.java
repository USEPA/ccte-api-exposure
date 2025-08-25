package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.HttkData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface HttkDataRepository extends JpaRepository<HttkData, Integer> {

    List<HttkData> findByDtxsid(String dtxsid);

    <T> List<T> findByDtxsidInOrderByDtxsidAsc(String[] dtxsids, Class<T> type);

}