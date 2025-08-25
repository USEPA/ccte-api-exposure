package gov.epa.ccte.api.exposure.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description ="These are estimates of the average (geometric mean) exposure rate (mg/kg bodyweight/day) for the U.S. population. We are 50% confident that the exposure for the chemical is below the median estimate, and we are 95% confident that the average exposure rate is below the upper 95th percent estimate. Total population predictions are based upon consensus exposure model predictions and the similarity of the compound to those chemicals monitored by NHANES. The method for the total U.S. population was described in a 2018 publication, \"Consensus Modeling of Median Chemical Intake for the U.S. Population Based on Predictions of Exposure Pathways\".")
@Entity
@Table(name = "v_gen_expo_predictions", schema = "ep")
public class GenExpoPrediction {
    @Id
    @Size(max = 20)
    @Column(name = "dtxsid", length = 20)
    @Schema(description = "Chemical identifier")
    private String dtxsid;

    @Column(name = "production_volume")
    @Schema(description = "How much chemical is produced or imported in the United States")
    private BigDecimal productionVolume;

    @Size(max = 7)
    @Column(name = "units", length = 7)
    @Schema(description = "Units on production volume")
    private String units;

    @Column(name = "stockholm_convention")
    @Schema(description = "Whether (1) or not (0) the chemical is banned by the Stockholm Convention on persistent organic pollutants")
    private Integer stockholmConvention;

    @Column(name = "probability_dietary", precision = 5, scale = 4)
    @Schema(description = "QSPR-predicted probability that the chemical has human exposure via a dietary pathway")
    private BigDecimal probabilityDietary;

    @Column(name = "probability_residential", precision = 5, scale = 4)
    @Schema(description = "QSPR-predicted probability that the chemical has human exposure via a consumer use pathway")
    private BigDecimal probabilityResidential;

    @Column(name = "probability_pesticde", precision = 5, scale = 4)
    @Schema(description = "QSPR-predicted probability that the chemical has human exposure via a far-field pesticide pathway")
    private BigDecimal probabilityPesticde;

    @Column(name = "probability_industrial", precision = 5, scale = 4)
    @Schema(description = "QSPR-predicted probability that the chemical has human exposure via a far-field industrial pathway")
    private BigDecimal probabilityIndustrial;

}