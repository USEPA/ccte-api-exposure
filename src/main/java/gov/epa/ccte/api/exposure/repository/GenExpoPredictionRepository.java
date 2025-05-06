package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import gov.epa.ccte.api.exposure.projection.CCDGenExpoPrediciton;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@SuppressWarnings("unused")
@RepositoryRestResource(exported = false)
public interface GenExpoPredictionRepository extends JpaRepository<GenExpoPrediction, String> {

	<T>List<T> findByDtxsid(String dtxsid, Class<T> type);

    <T> List<T> findByDtxsidInOrderByDtxsidAsc(String[] dtxsids, Class<T> type);

    @Query(value = """
    			SELECT
    				'Production Volume' AS predictor,
    				gen.production_volume AS value,
    			    'kg/day' AS units		
    			FROM ep.v_gen_expo_predictions gen
    			WHERE gen.dtxsid = :dtxsid  
    			UNION ALL
    			SELECT
    				'Stockholm Convention' AS predictor,
    				gen.stockholm_convention AS value,
    			    'Presence/Absence' AS units	
    			FROM ep.v_gen_expo_predictions gen
    			WHERE gen.dtxsid = :dtxsid   
    			UNION ALL
    			SELECT
    				'Probability Dietary' AS predictor,
    				gen.probability_dietary AS value,
    			    'Likelihood from 0 (none) to 1 (certain)' AS units		
    			FROM ep.v_gen_expo_predictions gen
    			WHERE gen.dtxsid = :dtxsid  
    			UNION ALL
    			SELECT
    				'Probability Residential' AS predictor,
    				gen.probability_residential AS value,
    			    'Likelihood from 0 (none) to 1 (certain)' AS units	
    			FROM ep.v_gen_expo_predictions gen
    			WHERE gen.dtxsid = :dtxsid  
    			UNION ALL
    			SELECT
    				'Probability Pesticde' AS predictor,
    				gen.probability_pesticde AS value,
    			    'Likelihood from 0 (none) to 1 (certain)' AS units		
    			FROM ep.v_gen_expo_predictions gen
    			WHERE gen.dtxsid = :dtxsid   
    			UNION ALL
    			SELECT
    				'Probability Industrial' AS predictor,
    				gen.probability_industrial AS value,
    			    'Likelihood from 0 (none) to 1 (certain)' AS units		
    			FROM ep.v_gen_expo_predictions gen
    			WHERE gen.dtxsid = :dtxsid   
    		""", nativeQuery = true)
    List<CCDGenExpoPrediciton> findByDtxsid(String dtxsid);
}