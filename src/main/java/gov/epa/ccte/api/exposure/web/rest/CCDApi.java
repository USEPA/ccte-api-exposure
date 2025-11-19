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
        description = "Collection of endpoints used to populate CompTox Chemicals Dashboard (CCD) Exposure tabs.")
@SecurityRequirement(name = "api_key")
@RequestMapping( value = "exposure/ccd", produces = MediaType.APPLICATION_JSON_VALUE )
public interface CCDApi {

    @Operation(summary = "Get Chemical Weight Fractions data by DTXSID", description = "return Chemical Weight Fractions data for requested DTXSID")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDChemicalWeightFractions.class}))),
    })
    @RequestMapping(value = "/chem-weight-fractions/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDChemicalWeightFractions> getChemicalWeightFractionsByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Get General Use Keywords data by DTXSID", description = "return General Use Keywords data for requested DTXSID")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDGeneralUseKeywords.class}))),
    })
    @RequestMapping(value = "/keywords/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDGeneralUseKeywords> getGeneralUseKeywordsByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Get Product Use Category data by DTXSID", description = "return Product Use Category data for requested DTXSID")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDProductUseCategory.class}))),
    })
    @RequestMapping(value = "/puc/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDProductUseCategory> getProductUseCategoryByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Get Reported Functional Use data by DTXSID", description = "return Reported Functional Use data for requested DTXSID")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDReportedFunctionalUse.class}))),
    })
    @RequestMapping(value = "/functional-use/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDReportedFunctionalUse> getReportedFunctionalUseByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

    @Operation(summary = "Get Biomonitoring data by DTXSID with CCD projection", 
    		   description = "return NHANES inferences data for requested DTXSID. There is an available projection aligned with what's available on the CCD Exposure Biomonitoring tab: ccd-biomonitoring. " +
                             "If no projection is specified, a default CCDBiomonitoring projection will be returned.")
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

    @Operation(summary = "Get Production Volume data by dtxsid", description = "return Production Volume data for requested dtxsid")
    @ApiResponses(value= {
            @ApiResponse(responseCode = "200", description = "OK",  content = @Content( mediaType = "application/json",
                    schema=@Schema(oneOf = {CCDProductionVolume.class}))),
    })
    @RequestMapping(value = "/production-volume/search/by-dtxsid/{dtxsid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<CCDProductionVolume> getProductionVolumeDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid);

}
