package gov.epa.ccte.api.exposure.projection;

public interface CCDDemoExpoPrediciton {

	String getDemographic();
	String getPredictor();
	Double getMedian();
	Double getU95();
	String getUnits();
}
