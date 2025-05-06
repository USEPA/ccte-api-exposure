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
@Table(name = "mv_production_volume", schema = "prodvol")
public class CCDProductionVolume {
	@Id
	@Column(name = "id")
	private Integer id;
	
    @Size(max = 50)
    @Column(name = "dtxsid")
    private String dtxsid;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "amount")
    private String amount;
    
}
