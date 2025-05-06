package gov.epa.ccte.api.exposure.domain;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "mv_t_ccd_product_use_category", schema = "chemexpo")
public class CCDProductUseCategory {
    @Id
    @Column(name = "id")
    private Long id;
    
    @Size(max = 50)
    @Column(name = "dtxsid")
    private String dtxsid;

    @Size(max = 202)
    @Column(name = "display_puc")
    private String displayPuc;
    
    @Size(max = 50)
    @Column(name = "puc_kind")
    private String pucKind;
    
    @Column(name = "prod_count")
    private Long prodCount;

    @Size(max = 50)
    @Column(name = "gen_cat")
    private String genCat;

    @Size(max = 50)
    @Column(name = "prod_fam")
    private String prodfam;

    @Size(max = 100)
    @Column(name = "prod_type")
    private String prodtype;

    @Column(name = "puc_definition")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String definition;
}
