package gov.epa.ccte.api.exposure.projection;

import gov.epa.ccte.api.exposure.domain.QsurData;

import java.math.BigDecimal;

/**
 * Projection for {@link QsurData}
 */
public interface QsurDataAll {
	
	String getDtxsid();
    String getHarmonizedFunctionalUse();
    BigDecimal getProbability();
    
	void setDtxsid(String dtxsid);
	void setHarmonizedFunctionalUse(String harmonizedFunctionalUse);
	void setProbability(BigDecimal probability);

}