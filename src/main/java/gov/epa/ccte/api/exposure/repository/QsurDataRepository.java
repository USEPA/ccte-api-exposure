package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.QsurData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface QsurDataRepository extends JpaRepository<QsurData, Integer> {
  @Transactional(readOnly = true)
  <T>
  List<T> findByDtxsidOrderByHarmonizedFunctionalUseAsc(String dtxsid, Class<T> type);
}