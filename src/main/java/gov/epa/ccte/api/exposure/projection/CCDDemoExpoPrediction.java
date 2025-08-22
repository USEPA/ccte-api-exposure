package gov.epa.ccte.api.exposure.projection;

public interface CCDDemoExpoPrediction {

	String getDemographic();
	String getPredictor();
	Double getMedian();
	Double getU95();
	String getUnits();
	
	void setDemographic(String demographic);
	void setPredictor(String predictor);
	void setMedian(Double median);
	void setU95(Double u95);
	void setUnits(String units);
	
}
