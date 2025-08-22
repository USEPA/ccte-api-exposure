package gov.epa.ccte.api.exposure.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

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

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mv_t_ccd_chemical_weight_fractions", schema = "chemexpo")
public class CCDChemicalWeightFractions {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Size(max = 50)
    @Column(name = "dtxsid")
    private String dtxsid;
    
    @Size(max = 255)
    @Column(name = "prod_name")
    private String prodName;
    
    @Size(max = 202)
    @Column(name = "display_puc")
    private String displayPuc;
    
    @Size(max = 50)
    @Column(name = "puc_kind")
    private String pucKind;
    
    @Column(name = "lower_weight_fraction", precision = 16, scale = 15)
    private BigDecimal lowerweightfraction;

    @Column(name = "upper_weight_fraction", precision = 16, scale = 15)
    private BigDecimal upperweightfraction;

    @Size(max = 50)
    @Column(name = "weight_fraction_type")
    private String weightfractiontype;
    
    @Size(max = 50)
    @Column(name = "gen_cat")
    private String gencat;

    @Size(max = 50)
    @Column(name = "prod_fam")
    private String prodfam;

    @Size(max = 100)
    @Column(name = "prod_type")
    private String prod_type;
    
    @Column(name = "puc_definition")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String pucDefinition;
    
    @Size(max = 50)
    @Column(name = "source_name")
    private String sourceName;
    
    @Column(name = "source_description")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String sourceDescription;
    
    @Size(max = 150)
    @Column(name = "source_url")
    private String sourceUrl;
    
    @Column(name = "source_download_date")
    private LocalDate sourceDownloadDate;
    
    @Column(name = "prod_count")
    private Long productCount;
}
