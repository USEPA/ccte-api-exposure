package gov.epa.ccte.api.exposure.domain;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description ="The information here describes records associated with reported statistics from aggregate studies in MMDB with their associated source and metadata information.")
@Entity
@Table(name = "mv_mmdb_aggregate", schema = "mmdb")
public class MMDBAggregate {
	@Id
	@Column(name = "id")
	@Schema(description ="Unique database ID for this individual table record")
	private Long id;

	@Size(max = 120)
	@Column(name = "full_source_name", length = 120)
	@Schema(description ="Full name of the data source")
	private String fullSourceName;

	@Size(max = 200)
	@Column(name = "reported_chemical_name", length = 200)
	@Schema(description ="Any reported chemical name reported in the raw data")
	private String chemicalName;

    @Size(max = 20)
    @Column(name = "dtxsid", length = 20)
    @Schema(description ="DSSTox chemical structure ID")
    private String dtxsid;

	@Size(max = 300)
	@Column(name = "preferred_name", length = 300)
	@Schema(description ="Preferred chemical name for this DTXSID")
	private String preferredName;

    @Size(max = 50)
    @Column(name = "reported_casrn")
    @Schema(description = "Any reported CAS number reported in the raw data (any format)")
    private String CASNumber;

    @Size(max = 20)
    @Column(name = "casrn")
    @Schema(description = "CASRN associated with this DTXSID")
    private String casrn;

    @Column(name = "reported_result")
    @Schema(description = "Reported value (any format) for reported_statistic")
    private String result;

    @Size(max = 100)
    @Column(name = "reported_units")
    @Schema(description = "Any reported units included in the raw data (any format)")
    private String units;

    @Column(name = "cleaned_units")
    @Schema(description = "Units from the raw data formatted for consistency")
    private String cleanedUnits;

    @Size(max = 100)
    @Column(name = "reported_statistic")
    @Schema(description = "Name of the reported statistic in the raw data")
    private String statistic;

    @Column(name = "reported_n")
    @Schema(description = "Reported sample size")
    private String sampleSize;

    @Column(name = "lod")
    @Schema(description = "Limit of detection associated witht he study, if available")
    private String lod;

    @Column(name = "loq")
    @Schema(description = "Limit of quantification associated witht he study, if available")
    private String loq;

    @Column(name = "reported_num_detects")
    @Schema(description = "Reported number of detections")
    private String numDetects;

    @Column(name = "reported_num_nds")
    @Schema(description = "Any reported number of nondetects in the raw data")
    private String numNonDetects;

    @Column(name = "reported_detect_rate")
    @Schema(description = "Reported rate of detection (percent or fraction) included in the raw data (any format)")
    private String rateDetects;

	@Column(name = "detected")
	@Schema(description ="Single variable indicating whether observation is associated with detection of the chemical (1:yes; 2:no; NA:could not be determined conclusively)")
	private Integer detected;

	@Column(name = "detect_conflict")
	@Schema(description ="A quality flag to note if fields used to determine if a chemical was detected were in conflict, resulting in less certain detected field designation (1:the detected field for a chemical sample is less certain; 0:no conflict)")
	private Integer detectedConflict;

    @Column(name = "detect_note")
    @Schema(description = "Description of detected status")
    private String notesDetects;

    @Size(max = 200)
    @Column(name = "reported_species")
    @Schema(description = "Any species name (biota) reported in the raw data")
    private String species;

    @Size(max = 120)
    @Column(name = "reported_media")
    @Schema(description = "Any media name reported in the raw data")
    private String media;

    @Size(max = 200)
    @Column(name = "harmonized_medium")
    @Schema(description = "Harmonized medium associated with the reported_media")
    private String harmonizedMedium;

    @Size(max = 500)
    @Column(name = "reported_population")
    @Schema(description = "Any reported description of the population studied")
    private String population;

    @Column(name = "reported_subpopulation")
    @Schema(description = "Any reported subpopulation of human subjects included in the raw data (any format)")
    private String subPopulation;

    @Size(max = 100)
    @Column(name = "reported_collection_activity_id")
    @Schema(description = "Any reported collection activity ID reported in the raw data")
    private String collectionActivityId;

    @Column(name = "reported_dates")
    @Schema(description = "Any reported date information for sample collection in the raw data (any format)")
    private String dates;

    @Column(name = "years")
    @Schema(description = "Inclusive year range of sample collection in the raw data (any format)")
    private String years;

    @Size(max = 500)
    @Column(name = "reported_location")
    @Schema(description = "Any specific location reported in the raw data that does not fit other location variables (any format)")
    private String location;

    @Column(name = "state_or_province")
    @Schema(description = "U.S. state or international province where sample was collected")
    private String stateOrProvince;

    @Size(max = 60)
    @Column(name = "us_county")
    @Schema(description = "U.S. county where sample was collected")
    private String county;

    @Column(name = "country")
    @Schema(description = "Country where sample was collected")
    private String country;

    @Size(max = 200)
    @Column(name = "qc_flag")
    @Schema(description = "Flag indicating if raw data included any quality flags for the record")
    private String qualityFlag;

    @Size(max = 500)
    @Column(name = "reported_link")
    @Schema(description = "Any web link to location of the record in the original data source")
    private String link;

    @Size(max = 300)
    @Column(name = "reported_reference")
    @Schema(description = "Any literature reference included in the raw data (any format)")
    private String reference;

    @Column(name = "data_version", length = Integer.MAX_VALUE)
    @Schema(description = "Release version of the data")
    private String version;

    @Column(name = "export_date")
    @Schema(description = "Date this data was inserted into a materialized view")
    private LocalDate exportDate;

}