package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import gov.epa.ccte.api.exposure.domain.CCDChemicalWeightFractions;

@RepositoryRestResource(exported = false)
public interface CCDChemicalWeightFractionsRepository extends JpaRepository<CCDChemicalWeightFractions, Long>{

    @Transactional(readOnly = true)
    <T>List<T> findByDtxsid(String dtxsid);
}
