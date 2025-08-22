package gov.epa.ccte.api.exposure.projection;

import java.math.BigDecimal;

public interface CCDBiomonitoringAll {
	
	String getDtxsid();
	String getLabel();
	BigDecimal getMedian();
	BigDecimal getLower95th();
	BigDecimal getUpper95th();
	String getHoverMsg();
	
	void setDtxsid(String dtxsid);
	void setLabel(String label);
	void setMedian(BigDecimal median);
	void setLower95th(BigDecimal lower95th);
	void setUpper95th(BigDecimal upper95th);
	void setHoverMsg(String hoverMsg);
}
