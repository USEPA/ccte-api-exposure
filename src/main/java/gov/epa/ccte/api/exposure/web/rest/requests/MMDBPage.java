package gov.epa.ccte.api.exposure.web.rest.requests;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class MMDBPage {
	private String medium;
    private Long totalRecords;
    private Integer recordsOnPage;
    private Integer pageNumber;
    private Integer totalPages;
    private List<?> data;
}
