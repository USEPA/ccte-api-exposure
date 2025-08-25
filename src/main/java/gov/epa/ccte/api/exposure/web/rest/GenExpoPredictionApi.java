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
        description = "API endpoints for general prediction in exposure data.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/seem/general", produces = MediaType.APPLICATION_JSON_VALUE )
public interface GenExpoPredictionApi {

    @Operation(summary = "Find general prediction SEEMs data by dtxsid", description = "return demographic prediction SEEMs data for requested dtxsid")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {GenExpoPrediction.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> getGenExpoPredictionByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232")
    									@PathVariable("dtxsid") String dtxsid,
    									@Parameter(description = "Specifies whether to use projection. Optional: ccd-general.")
    									@RequestParam(value = "projection", required = false) String projection);

    @Operation(summary = "Find general exposure prediction SEEMs data by batch of dtxsids", description = "return general prediction SEEMs data for requested dtxsids")
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
