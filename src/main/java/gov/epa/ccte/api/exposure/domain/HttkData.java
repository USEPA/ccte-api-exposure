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
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The information here describes toxicokinetics in humans. Values are 1) measured either in vitro or in vivo, 2) predicted from chemical properties using in silico tools, or 3) computed with mathematical models simulating toxicokinetics. Note: intrinsic hepatic clearance and fraction unbound in plasma values can have measured values listed, but these may be assumed from measured data using a surrogate species. The Data Source Species column identifies the measured data species source. We use these assumed measured values in calculations to estimate other outcomes, such as volume of distribution, PK half life, and steady-state plasma concentration. The in vitro measured values reflect the value curated for the open source R package “httk”. The computed values are generated with httk using the reported in vitro values. \"https://CRAN.R-project.org/package=httk\". The in vivo measured values are estimated from toxicokinetic concentration vs. time contained in the CvTdb (https://doi.org/10.1038/s41597-020-0455-1). In vivo estimates are calculated using R package “invivoPKfit” (https://github.com/USEPA/CompTox-ExpoCast-invivoPKfit)")
@Entity
@Table(name = "v_httk_data", schema = "ep")
public class HttkData {
    @Id
    @ColumnDefault("nextval('ep.v_httk_data_id_seq'::regclass)")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "dtxsid", length = 20)
    @Schema(description = "Chemical identifier")
    private String dtxsid;

    @Size(max = 15)
    @Column(name = "parameter", length = 15)
    @Schema(description = "The toxicokinetic parameter. Clint = Intrinsic hepatic clearance rate, Fup = fraction unbound in plasma, Vd = effective volume of distribution, Days.Css = number of days to reach steady-state from constant exposure, Css = plasma concentration after reaching steady-state, TK.Half.Life = number of hours for half of chemical in body to be eliminated")
    private String parameter;

    @Size(max = 15)
    @Column(name = "measured_text", length = 15)
    private String measuredText;

    @Column(name = "measured")
    @Schema(description = "Experimentally measured value for the parameter")
    private BigDecimal measured;

    @Size(max = 15)
    @Column(name = "predicted_text", length = 15)
    private String predictedText;

    @Column(name = "predicted")
    @Schema(description = "The predicted value for the parameter")
    private BigDecimal predicted;

    @Size(max = 30)
    @Column(name = "units", length = 30)
    @Schema(description = "Units on the predicted parameter")
    private String units;

    @Size(max = 15)
    @Column(name = "model", length = 15)
    @Schema(description = "The toxicokinetic model used to predict the parameter")
    private String model;

    @Size(max = 150)
    @Column(name = "reference", length = 150)
    @Schema(description = "Peer reviewed journal article(s) from which measured or predicted value was derived")
    private String reference;

    @Size(max = 5)
    @Column(name = "percentile", length = 5)
    @Schema(description = "For humans, what fraction of the population have a lower value given the same dose. Not relevant to animal species")
    private String percentile;

    @Size(max = 10)
    @Column(name = "species", length = 10)
    private String species;

    @Size(max = 10)
    @Column(name = "data_source_species", length = 10)
    private String dataSourceSpecies;

}