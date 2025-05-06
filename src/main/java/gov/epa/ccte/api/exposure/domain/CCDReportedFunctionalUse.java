package gov.epa.ccte.api.exposure.domain;

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
@Table(name = "mv_t_ccd_reported_functional_use", schema = "chemexpo")
public class CCDReportedFunctionalUse {
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max = 50)
    @Column(name = "dtxsid")
    private String dtxsid;
    
    @Size(max = 100)
    @Column(name = "function_category")
    private String category;

    @Size(max = 255)
    @Column(name = "reported_function")
    private String definition;
}
