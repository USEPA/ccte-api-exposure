package gov.epa.ccte.api.exposure.domain;

import java.math.BigDecimal;

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
@Table(name = "biomonitor_data", schema = "nhanes")
public class CCDBiomonitoring {
	@Id
	@Column(name = "id")
	private Integer id;
	
    @Size(max = 50)
    @Column(name = "dtxsid")
    private String dtxsid;
    
    @Column(name = "demographic_group")
    private String demographic;
    
    @Column(name = "intake_rate_mgpkgpday")
    private BigDecimal median;
    
    @Column(name = "up95")
    private BigDecimal upperBound;
    
    @Column(name = "low95")
    private BigDecimal lowerBound;
    
    @Column(name = "nhanes_cohort")
    private String nhanesCohort;
    
}
