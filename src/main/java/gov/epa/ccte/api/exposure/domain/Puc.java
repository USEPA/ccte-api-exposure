package gov.epa.ccte.api.exposure.domain;

import lombok.*;

import org.hibernate.annotations.JdbcTypeCode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import org.hibernate.type.SqlTypes;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mv_t_puc", schema = "chemexpo")
public class Puc {
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max = 50)
    @Column(name = "puc_kind", length = 50)
    private String kindName;

    @Size(max = 50)
    @Column(name = "gen_cat", length = 50)
    private String genCat;

    @Size(max = 50)
    @Column(name = "prod_fam", length = 50)
    private String prodfam;

    @Size(max = 100)
    @Column(name = "prod_type", length = 100)
    private String prodtype;

    @Column(name = "puc_definition")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String definition;

}