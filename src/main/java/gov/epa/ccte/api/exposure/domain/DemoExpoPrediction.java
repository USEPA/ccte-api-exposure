package gov.epa.ccte.api.exposure.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Schema(description = "These are estimates of the average (geometric mean) exposure rate (mg/kg bodyweight/day) for the U.S. population. We are 50% confident that the exposure for the chemical is below the median estimate, and we are 95% confident that the average exposure rate is below the upper 95th percent estimate. Total population predictions are based upon consensus exposure model predictions and the similarity of the compound to those chemicals monitored by NHANES. The method for the demographic-specific predictions are based upon a simpler, heuristic model described in the 2014 publication \"High Throughput Heuristics for Prioritizing Human Exposure to Environmental Chemicals\".")
@Entity
@Table(name = "v_demo_expo_predictions", schema = "ep")
public class DemoExpoPrediction {
    @Id
    @ColumnDefault("nextval('ep.v_demo_expo_predictions_id_seq'::regclass)")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 20)
    @Column(name = "dtxsid", length = 20)
    @Schema(description = "Chemical identifier")
    private String dtxsid;

    @Size(max = 25)
    @Column(name = "demographic", length = 25)
    @Schema(description = "Which portion of the U.S. population these values refer to")
    private String demographic;

    @Size(max = 25)
    @Column(name = "predictor", length = 25)
    @Schema(description = "The model/approach used to make a prediction")
    private String predictor;

    @Column(name = "median")
    @Schema(description = "The median predicted value")
    private Double median;

    @Size(max = 25)
    @Column(name = "median_text", length = 25)
    private String medianText;

    @Column(name = "l95")
    @Schema(description = "The lower 95th percentile confidence value (uncertainty) for the prediction")
    private Double l95;

    @Size(max = 25)
    @Column(name = "l95_text", length = 25)
    private String l95Text;

    @Column(name = "u95")
    @Schema(description = "The upper 95th percentile confidence value (uncertainty) for the prediction")
    private Double u95;

    @Size(max = 25)
    @Column(name = "u95_text", length = 25)
    private String u95Text;

    @Size(max = 20)
    @Column(name = "units", length = 20)
    @Schema(description = "The units of the prediction")
    private String units;

    @Column(name = "ad")
    @Schema(description = "Whether (1) or not (0) the chemical is within the applicability domain of the predictor")
    private Integer ad;

    @Size(max = 20)
    @Column(name = "reference", length = 20)
    @Schema(description = "The peer reviewed journal article explaining how the prediction was made")
    private String reference;

}