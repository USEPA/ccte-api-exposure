package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.exposure.domain.CCDGeneralUseKeywords;

public interface CCDGeneralUseKeywordsRepository extends JpaRepository<CCDGeneralUseKeywords, Long>{
	
    @Transactional(readOnly = true)
    <T>List<T> findByDtxsid(String dtxsid);
}
