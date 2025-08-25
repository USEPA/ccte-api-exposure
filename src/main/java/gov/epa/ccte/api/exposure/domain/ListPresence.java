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
@Table(name = "mv_t_list_presence", schema = "chemexpo")
public class ListPresence {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "dtxsid")
    private String dtxsid;

    @Column(name = "doc_id")
    private Integer docid;

    @Size(max = 500)
    @Column(name = "doc_title", length = 500)
    private String doctitle;

    @Size(max = 250)
    @Column(name = "doc_subtitle", length = 250)
    private String docsubtitle;

    @Size(max = 25)
    @Column(name = "doc_date", length = 25)
    private String docdate;

    @Size(max = 255)
    @Column(name = "organization")
    private String organization;

    @Size(max = 255)
    @Column(name = "reported_function")
    private String reportedfunction;

    @Size(max = 100)
    @Column(name = "function_category", length = 100)
    private String functioncategory;

    @Size(max = 200)
    @Column(name = "component", length = 200)
    private String component;

    @Column(name = "keyword_set")
    @JdbcTypeCode(SqlTypes.LONGVARCHAR)
    private String keywordset;

}