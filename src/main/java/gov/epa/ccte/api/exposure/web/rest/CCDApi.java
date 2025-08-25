package gov.epa.ccte.api.exposure.web.rest;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gov.epa.ccte.api.exposure.domain.CCDBiomonitoring;
import gov.epa.ccte.api.exposure.domain.CCDChemicalWeightFractions;
import gov.epa.ccte.api.exposure.domain.CCDGeneralUseKeywords;
import gov.epa.ccte.api.exposure.domain.CCDProductUseCategory;
import gov.epa.ccte.api.exposure.domain.CCDProductionVolume;
import gov.epa.ccte.api.exposure.domain.CCDReportedFunctionalUse;
import gov.epa.ccte.api.exposure.projection.CCDBiomonitoringAll;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * REST controller for getting available CCD Data Resources.
 */
@Tag(name = "CCD Data Resource",
        description = "API endpoints for CompTox Chemicals Dashboard exposure tabs.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/ccd", produces = MediaType.APPLICATION_JSON_VALUE )
public interface CCDApi {

    @Operation(summary = "Find Chemical Weight Fractions data by dtxsid", description = "return Chemical Weight Fractions data for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDChemicalWeightFractions.class}))),
    })
    @RequestMapping(value = "/chem-weight-fractions/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDChemicalWeightFractions> getChemicalWeightFractionsByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Find General Use Keywords data by dtxsid", description = "return General Use Keywords data for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDGeneralUseKeywords.class}))),
    })
    @RequestMapping(value = "/keywords/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDGeneralUseKeywords> getGeneralUseKeywordsByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Find Product Use Category data by dtxsid", description = "return Product Use Category data for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDProductUseCategory.class}))),
    })
    @RequestMapping(value = "/puc/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDProductUseCategory> getProductUseCategoryByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Find Reported Functional Use data by dtxsid", description = "return Reported Functional Use data for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDReportedFunctionalUse.class}))),
    })
    @RequestMapping(value = "/functional-use/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDReportedFunctionalUse> getReportedFunctionalUseByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Find Biomonitoring data by dtxsid with ccd projection", 
    		   description = "return NHANES Inferences for requested dtxsid" +
                             "there is an available projection for ccd exposure biomonitoring page:" +
    				         "ccd-biomonitoring" +
                             "If no projection is specified, the default CCDBiomonitoring data will be returned")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDBiomonitoring.class, CCDBiomonitoringAll.class}))),
    })
    @RequestMapping(value = "/monitoring-data/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<?> getBiomonitoringDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID7020182") 
                                         @PathVariable("dtxsid") String dtxsid,
                             	        @Parameter(description = "Specifies if projection is used. Option: ccd-biomonitoring, " +
            	                                "If omitted, the default CCDBiomonitoring data is returned.")
            	                        @RequestParam(value = "projection", required = false) String projection);

    @Operation(summary = "Find Production Volume data by dtxsid", description = "return Production Volume data for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDProductionVolume.class}))),
    })
    @RequestMapping(value = "/production-volume/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDProductionVolume> getProductionVolumeDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

}
