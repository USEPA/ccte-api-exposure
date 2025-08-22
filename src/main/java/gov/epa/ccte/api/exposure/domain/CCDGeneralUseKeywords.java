package gov.epa.ccte.api.exposure.domain;

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
@Table(name = "mv_t_ccd_general_use_keywords", schema = "chemexpo")
public class CCDGeneralUseKeywords {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    
    @Column(name = "keyword_set")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String keywordset;
    
    @Column(name = "source_count")
    private Long sourceCount;
    
    @Size(max = 50)
    @Column(name = "dtxsid")
    private String dtxsid;
    
}
