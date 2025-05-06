package gov.epa.ccte.api.exposure.domain;

import lombok.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mv_t_product_data", schema = "chemexpo")
public class ProductData {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @Column(name = "dtxsid", length = 50)
    private String dtxsid;

    @Column(name = "doc_id")
    private Integer docid;

    @Size(max = 500)
    @Column(name = "doc_title", length = 500)
    private String doctitle;

    @Size(max = 25)
    @Column(name = "doc_date", length = 25)
    private String docdate;

    @Size(max = 255)
    @Column(name = "prod_name")
    private String productname;

    @Size(max = 50)
    @Column(name = "gen_cat", length = 50)
    private String gencat;

    @Size(max = 50)
    @Column(name = "prod_fam", length = 50)
    private String prodfam;

    @Size(max = 100)
    @Column(name = "prod_type", length = 100)
    private String prod_type;

    @Size(max = 100)
    @Column(name = "classification_method", length = 100)
    private String classificationmethod;

    @Size(max = 100)
    @Column(name = "raw_min_comp", length = 100)
    private String rawmincomp;

    @Size(max = 100)
    @Column(name = "raw_max_comp", length = 100)
    private String rawmaxcomp;

    @Size(max = 100)
    @Column(name = "raw_central_comp", length = 100)
    private String rawcentralcomp;

    @Size(max = 50)
    @Column(name = "unit_type", length = 50)
    private String unittype;

    @Column(name = "lower_weight_fraction", precision = 16, scale = 15)
    private BigDecimal lowerweightfraction;

    @Column(name = "upper_weight_fraction", precision = 16, scale = 15)
    private BigDecimal upperweightfraction;

    @Column(name = "central_weight_fraction", precision = 16, scale = 15)
    private BigDecimal centralweightfraction;

    @Size(max = 50)
    @Column(name = "weight_fraction_type", length = 50)
    private String weightfractiontype;

    @Size(max = 200)
    @Column(name = "component", length = 200)
    private String component;

}