package gov.epa.ccte.api.exposure.projection;

/**
 * Projection for {@link gov.epa.ccte.api.exposure.domain.FunctionalUse}
 */
public interface FunctionalUseAll {
    Long getId();

    String getDtxsid();

    String getDatatype();

    Integer getDocid();

    String getDoctitle();

    String getDocdate();

    String getReportedfunction();

    String getFunctioncategory();
}