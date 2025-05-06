package gov.epa.ccte.api.exposure.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gov.epa.ccte.api.exposure.domain.CCDBiomonitoring;
import gov.epa.ccte.api.exposure.projection.CCDBiomonitoringAll;

import org.springframework.transaction.annotation.Transactional;

public interface CCDBiomonitoringRepository extends JpaRepository<CCDBiomonitoring, Integer>{

    @Transactional(readOnly = true)
    <T> List<T> findByDtxsid(String dtxsid, Class<T> type);
    
    @Query(value = """
    					SELECT
    					    bio.dtxsid, 
    					    bio.demographic_group AS label,
    					    bio.intake_rate_mgpkgpday AS median,
    					    bio.up95 AS upper95th,
    					    bio.low95 AS lower95th,
    					CASE 
    					 	WHEN demographic_group = 'BMI <= 30' THEN 'The body mass index (BMI) is a value derived from the mass (weight) and height of an individual. The BMI is defined as the body mass divided by the square of the body height, and is universally expressed in units of kg/m2, resulting from mass in kilograms and height in meters.'  
    					    WHEN demographic_group = 'BMI > 30' THEN 'The body mass index (BMI) is a value derived from the mass (weight) and height of an individual. The BMI is defined as the body mass divided by the square of the body height, and is universally expressed in units of kg/m2, resulting from mass in kilograms and height in meters.'  
                            WHEN demographic_group = 'ReproAgeFemale' THEN 'Here, women of "reproductive age" are defined as any woman aged 16-49 years.' 
                            ELSE 'null'
                        END AS hoverMsg
    					FROM
    					    nhanes.biomonitor_data bio     					  					
    					WHERE
    					    bio.dtxsid = :dtxsid
    					ORDER BY label ASC;
    				""", nativeQuery = true)
    List<CCDBiomonitoringAll> findByDtxsidWithMsgColumn(@Param("dtxsid")String dtxsid);
}
