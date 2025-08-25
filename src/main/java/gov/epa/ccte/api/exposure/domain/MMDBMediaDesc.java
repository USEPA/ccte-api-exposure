package gov.epa.ccte.api.exposure.domain;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description ="The information here describes all searchable harmonized medium categories and their corresponding definitions.")
@Entity
@Table(name = "mv_mmdb_media", schema = "mmdb")
public class MMDBMediaDesc {
	@Id
	@Column(name = "id")
	@Schema(description ="Unique database ID for this individual table record")
	private Integer id;

    @Column(name = "harmonized_medium")
    @Schema(description = "Harmonized medium associated with the reported_media")
    private String harmonizedMedium;

    @Column(name = "harmonized_medium_description")
    @Schema(description = "Detailed description of harmonized media categories")
    private String harmonizedMediumDesc;

    @Column(name = "data_version", length = Integer.MAX_VALUE)
    @Schema(description = "Release version of the data")
    private String version;

    @Column(name = "export_date")
    @Schema(description = "Date this data was inserted into a materialized view")
    private LocalDate exportDate;
}
