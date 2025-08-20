package gov.epa.ccte.api.exposure.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mv_t_list_presence_tags", schema = "chemexpo")
public class ListPresenceTag {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 100)
    @Column(name = "lp_tag_name", length = 100)
    private String tagName;

    @Size(max = 750)
    @Column(name = "lp_tag_definition", length = 750)
    private String tagDefinition;

    @Size(max = 50)
    @Column(name = "lp_tag_kind", length = 50)
    private String tagKind;
}