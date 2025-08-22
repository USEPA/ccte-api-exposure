package gov.epa.ccte.api.exposure.projection;

/**
 * Projection for {@link gov.epa.ccte.api.exposure.domain.MMDBMediaDesc}
 */
public interface MMDBMediaDescSummary {

	String getHarmonizedMedium();
	String getHarmonizedMediumDesc();
	
	void setHarmonizedMedium(String harmonizedMedium);
	void setHarmonizedMediumDesc(String harmonizedMediumDesc);
}
