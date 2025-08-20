package gov.epa.ccte.api.exposure.projection;

public interface CCDGenExpoPrediction {

	String getPredictor();
	Double getValue();
	String getUnits();
	
	void setPredictor(String predictor);
	void setValue(Double value);
	void setUnits(String units);
}
