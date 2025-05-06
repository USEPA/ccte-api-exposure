package gov.epa.ccte.api.exposure.domain;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;


@Getter
@Setter
@Entity
@Table(name = "mv_t_functional_use_resource", schema = "chemexpo")
public class FunctionalUse {
    @Id
    @Column(name = "id")
    private Long id;

    @Size(max = 50)
    @Column(name = "dtxsid", length = 50)
    private String dtxsid;

    @Size(max = 50)
    @Column(name = "data_type", length = 50)
    private String datatype;

    @Column(name = "doc_id")
    private Integer docid;

    @Size(max = 500)
    @Column(name = "doc_title", length = 500)
    private String doctitle;

    @Size(max = 25)
    @Column(name = "doc_date", length = 25)
    private String docdate;

    @Size(max = 255)
    @Column(name = "reported_function")
    private String reportedfunction;

    @Size(max = 100)
    @Column(name = "function_category", length = 100)
    private String functioncategory;

}