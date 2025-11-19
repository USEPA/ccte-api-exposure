package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.GenExpoPrediction}s.
 */
@Tag(name = "General Exposure Prediction Resource",
        description = "Collection of endpoints for general prediction data. SEEM (Systematic Empirical Evaluation of Models) is a framework developed by the US EPA to predict exposure to chemicals across the general population and demographic subsets of the US.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/seem/general", produces = MediaType.APPLICATION_JSON_VALUE )
public interface GenExpoPredictionApi {

    @Operation(summary = "Get SEEM general exposure prediction data by DTXSID", description = "return SEEM general exposure prediction data for requested DTXSID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {GenExpoPrediction.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> getGenExpoPredictionByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232")
    									@PathVariable("dtxsid") String dtxsid,
    									@Parameter(description = "Specifies whether to use projection. Optional: ccd-general.")
    									@RequestParam(value = "projection", required = false) String projection);

    @Operation(summary = "Get SEEM general exposure prediction data for a batch of DTXSIDs", description = "return SEEM general exposure prediction data for requested DTXSIDs")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {GenExpoPrediction.class}))),
    })
    @PostMapping(value = "/search/by-dtxsid/")
    @ResponseBody
    List<GenExpoPrediction> batchSearchGenExpoPrediction(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID00195485\\\",\\\"DTXSID00195400\\\"]\"")})})
                                                           @RequestBody String[] dtxsids);
}
