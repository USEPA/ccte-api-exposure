package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ListPresence;
import gov.epa.ccte.api.exposure.domain.ListPresenceTag;
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
 * REST controller for getting the {@link gov.epa.ccte.api.exposure.domain.FunctionalUse}s.
 */
@Tag(name = "List Presence Resource",
        description = "Collection of endpoints with list presence data, reflecting the occurrence of chemicals on lists present in publicly available documents (sourced from a variety of federal and state agencies and trade associations). These lists are tagged with List Presence Keywords (LPKs) which is a controlled vocabulary developed by EPA that describe broad use information for a chemical useful for general categorization of chemicals across uses, populations, and/or regulatory groups. These curated data are sourced from US EPA's Chemicals and Products Database (CPDat).")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/list-presence", produces = MediaType.APPLICATION_JSON_VALUE )
public interface ListPresenceApi {

    @Operation(summary = "Get List Presence data by DTXSID", description = "return list presence data for requested DTXSID")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {ListPresence.class}))),
    })
    @RequestMapping(value = "/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ListPresence> getListPresenceByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Get List Presence Tags", description = "return list presence tags")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {ListPresenceTag.class}))),
    })
    @RequestMapping(value = "/tags", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ListPresenceTag> getListPresenceTags();

    @Operation(summary = "Get List Presence data for a batch of DTXSIDs", description = "return list presence data for requested DTXSIDs")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json",
                    schema = @Schema(oneOf = {ListPresence.class}))),
    })
    @PostMapping(value = "/search/by-dtxsid/")
    @ResponseBody
    List<ListPresence> batchSearchListPresence(@io.swagger.v3.oas.annotations.parameters.RequestBody(required = true, description = "JSON array of DSSTox Substance Identifier",
            content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)),
                    examples = {@ExampleObject("\"[\\\"DTXSID7020182\\\",\\\"DTXSID9020112\\\"]\"")})})
                                                    @RequestBody String[] dtxsids);
}
