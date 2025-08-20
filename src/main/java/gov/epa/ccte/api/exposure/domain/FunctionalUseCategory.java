package gov.epa.ccte.api.exposure.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Table(name = "mv_t_functional_use_category", schema = "chemexpo")
public class FunctionalUseCategory {
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max = 100)
    @Column(name = "function_category", length = 100)
    private String category;

    @Column(name = "function_definition")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String definition;
}