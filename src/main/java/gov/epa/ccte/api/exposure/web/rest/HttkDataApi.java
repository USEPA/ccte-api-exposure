package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.HttkData;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.HttkData}s.
 */
@Tag(name = "httk Data Resource",
        description = "Collection of endpoints with data to support toxicokinetic modeling applications sourced from the US EPA high throughput toxicokinetics `httk` R package. Models to predict toxicokinetics (chemical absorption, distribution, metabolism, and excretion by the body) are tailored using chemical-specific in vitro data and physiological information.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/httk", produces = MediaType.APPLICATION_JSON_VALUE)
public interface HttkDataApi {

    @Operation(summary = "Get httk data by DTXSID", description = "return httk data for requested DTXSID")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {HttkData.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<HttkData> getHttkDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232")
                                       @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Get httk data by batch of DTXSIDs", description = "return httk data for requested DTXSIDs")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {HttkData.class}))),
    })
    @PostMapping(value = "/search/by-dtxsid/")
    @ResponseBody
    List<HttkData> batchSearchHttk(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID0027301\\\",\\\"DTXSID0027272\\\"]\"")})})
                                                         @RequestBody String[] dtxsids);
}
