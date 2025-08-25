package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.ProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface ProductDataRepository extends JpaRepository<ProductData, Long> {
    List<ProductData> findByDtxsid(String dtxsid);

    <T> List<T> findByDtxsidInOrderByDtxsidAsc(String[] dtxsids, Class<T> type);

}