package gov.epa.ccte.api.exposure.projection;

import java.math.BigDecimal;

public interface CCDBiomonitoringAll {
	
	String getDtxsid();
	String getLabel();
	BigDecimal getMedian();
	BigDecimal getLower95th();
	BigDecimal getUpper95th();
	String getHoverMsg();
}
