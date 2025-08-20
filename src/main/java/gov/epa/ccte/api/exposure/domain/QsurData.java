package gov.epa.ccte.api.exposure.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "mv_qsur_data", schema = "qsur")
public class QsurData {
    @Id
    @NotNull
    @Column(name = "id")
    private Integer id;

    @Size(max = 50)
    @Column(name = "dtxsid", length = 50)
    private String dtxsid;

    @Size(max = 50)
    @Column(name = "harmonized_functional_use", length = 50)
    private String harmonizedFunctionalUse;

    @Column(name = "probability")
    private BigDecimal probability;

}