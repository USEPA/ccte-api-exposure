package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.DemoExpoPrediction}s.
 */
@Tag(name = "Demographic Exposure Prediction Resource",
        description = "Collection of endpoints with SEEM demographic exposure prediction data. SEEM (Systematic Empirical Evaluation of Models) is a framework developed by the US EPA to predict exposure to chemicals across the general population and demographic subsets of the US.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/seem/demographic", produces = MediaType.APPLICATION_JSON_VALUE)
public interface DemoExpoPredictionApi {

    @Operation(summary = "Get SEEM Demographic Exposure Prediction data by DTXSID", description = "return SEEM demographic prediction data for requested DTXSID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {DemoExpoPrediction.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> getDemoExpoPredictionByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232")
    									@PathVariable("dtxsid") String dtxsid,
    									@Parameter(description = "Specifies whether to use projection. Optional: ccd-demographic.")
    									@RequestParam(value = "projection", required = false) String projection);

    @Operation(summary = "Get SEEM Demographic Exposure Prediction data for batch of DTXSIDs", description = "return SEEM demographic prediction data for requested DTXSIDs")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {DemoExpoPrediction.class}))),
    })
    @PostMapping(value = "/search/by-dtxsid/")
    @ResponseBody
    List<DemoExpoPrediction> batchSearchDemoExpoPrediction(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID00195506\\\",\\\"DTXSID0027301\\\"]\"")})})
                                                    @RequestBody String[] dtxsids);

}
