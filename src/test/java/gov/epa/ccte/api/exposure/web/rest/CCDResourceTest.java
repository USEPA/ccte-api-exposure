package gov.epa.ccte.api.exposure.web.rest;

import org.junit.jupiter.api.BeforeEach;

//This will test REST end-points in the CCDResource.java using WebMvcTest and MockitoBean

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

import gov.epa.ccte.api.exposure.domain.CCDBiomonitoring;
import gov.epa.ccte.api.exposure.projection.CCDBiomonitoringAll;
import gov.epa.ccte.api.exposure.domain.CCDChemicalWeightFractions;
import gov.epa.ccte.api.exposure.domain.CCDGeneralUseKeywords;
import gov.epa.ccte.api.exposure.domain.CCDProductUseCategory;
import gov.epa.ccte.api.exposure.domain.CCDProductionVolume;
import gov.epa.ccte.api.exposure.domain.CCDReportedFunctionalUse;
import gov.epa.ccte.api.exposure.repository.CCDBiomonitoringRepository;
import gov.epa.ccte.api.exposure.repository.CCDChemicalWeightFractionsRepository;
import gov.epa.ccte.api.exposure.repository.CCDGeneralUseKeywordsRepository;
import gov.epa.ccte.api.exposure.repository.CCDProductUseCategoryRepository;
import gov.epa.ccte.api.exposure.repository.CCDProductionVolumeRepository;
import gov.epa.ccte.api.exposure.repository.CCDReportedFunctionalUseRepository;


import java.math.BigDecimal;
import java.util.*;

@ActiveProfiles("test")
@WebMvcTest(CCDResource.class)
@RunWith(MockitoJUnitRunner.class)

public class CCDResourceTest {
	
    @Autowired
    private MockMvc mockMvc;
	
    @MockitoBean
    private CCDChemicalWeightFractionsRepository chemWeightRepository;
    @MockitoBean
    private CCDGeneralUseKeywordsRepository keywordsRepository;
    @MockitoBean
    private CCDProductUseCategoryRepository productUseRepository;
    @MockitoBean
    private CCDReportedFunctionalUseRepository functionalUseRepository;
    @MockitoBean
    private CCDBiomonitoringRepository biomonitoringRepository;
    @MockitoBean
    private CCDProductionVolumeRepository productionVolumeRepository;

    private CCDBiomonitoring ccdBiomonitoring;
    private CCDBiomonitoringAll ccdBiomonitoringAll;
    private CCDChemicalWeightFractions ccdChemicalWeightFractions;
    private CCDGeneralUseKeywords ccdGeneralUseKeywords;
    private CCDProductUseCategory ccdProductUseCategory;
    private CCDProductionVolume ccdProductionVolume;
    private CCDReportedFunctionalUse ccdReportedFunctionalUse;
    private ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    
    @BeforeEach
    void setUp(){
    	ccdBiomonitoring = CCDBiomonitoring.builder()
    			.id(606)
                .dtxsid("DTXSID7020182")
                .demographic("Total")
                .median(BigDecimal.valueOf(0.000017293))
                .upperBound(BigDecimal.valueOf(0.000017903))
                .lowerBound(BigDecimal.valueOf(0.000016691))
                .nhanesCohort("15-16")
    			.build();
    	
    	ccdChemicalWeightFractions = CCDChemicalWeightFractions.builder()
    			.id(1322892L)
                .dtxsid("DTXSID7020182")
                .prodName("Composition")
                .displayPuc("Not yet Categorized")
                .pucKind(null)
                .lowerweightfraction(BigDecimal.valueOf(0))
                .upperweightfraction(BigDecimal.valueOf(0.55))
                .weightfractiontype("reported")
                .gencat(null)
                .prodfam(null)
                .prod_type(null)
                .pucDefinition(null)
                .sourceName("SIRI")
                .sourceDescription("\"Products found in the SIRI database, a compilation of Material Safety Data Sheets (MSDS). Note the database may no longer be maintained.\"")
                .sourceUrl("http://hazard.com/msds/index.php")
                .sourceDownloadDate(null)
                .productCount(1L)
                .build();
    	
    	ccdGeneralUseKeywords = CCDGeneralUseKeywords.builder()
    			.id(40511L)
                .dtxsid("DTXSID7020182")
                .keywordset("OEHHA Proposition 65 (3/2019)")
                .sourceCount(1L)
                .build();
    	
    	ccdProductUseCategory = CCDProductUseCategory.builder()
    			.id(14261L)
                .dtxsid("DTXSID7020182")
                .displayPuc("Construction:construction adhesives")
                .pucKind("Occupation")
                .prodCount(1L)
                .genCat("Construction")
                .prodfam("construction adhesives")
                .prodtype("")
                .definition("Adhesives used in construction applications")
    			.build();
    	
    	ccdProductionVolume = CCDProductionVolume.builder()
    			.id(23113)
                .dtxsid("DTXSID7020182")
                .name("2019 NATIONALLY AGGREGATED PV")
                .amount("1,000,000,000 - <5,000,000,000 lb")
                .build();
    	
    	ccdReportedFunctionalUse = CCDReportedFunctionalUse.builder()
    			.id(28665L)
                .dtxsid("DTXSID7020182")
                .category("Hardener")
                .definition("hardener")
                .build();
    	
    	ccdBiomonitoringAll = factory.createProjection(CCDBiomonitoringAll.class);
    	ccdBiomonitoringAll.setLabel("12 - 19 years");
    	ccdBiomonitoringAll.setDtxsid("DTXSID7020182");
    	ccdBiomonitoringAll.setMedian(BigDecimal.valueOf(0.000016023));
    	ccdBiomonitoringAll.setLower95th(BigDecimal.valueOf(0.000014722));
    	ccdBiomonitoringAll.setUpper95th(BigDecimal.valueOf(0.000017608));
    	ccdBiomonitoringAll.setHoverMsg("null");
    	
    }
    
    @Test
    void testGetBiomonitoringDataByDtxsid() throws Exception {
        final List<CCDBiomonitoring> biomonitor = Collections.singletonList(ccdBiomonitoring);

        when(biomonitoringRepository.findByDtxsid("DTXSID7020182",CCDBiomonitoring.class)).thenReturn(biomonitor);

        mockMvc.perform(get("/exposure/ccd/monitoring-data/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(ccdBiomonitoring.getDtxsid()));

    }
    
    @Test
    void testGetBiomonitoringDataByDtxsidProjection() throws Exception {
        final List<CCDBiomonitoringAll> biomonitor = Collections.singletonList(ccdBiomonitoringAll);

        when(biomonitoringRepository.findByDtxsidWithMsgColumn("DTXSID7020182")).thenReturn(biomonitor);

        mockMvc.perform(get("/exposure/ccd/monitoring-data/search/by-dtxsid/{dtxsid}", "DTXSID7020182")
				.param("projection", "ccd-biomonitoring"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(ccdBiomonitoringAll.getDtxsid()));

    }
    
    @Test
    void testGetChemicalWeightFractionsByDtxsid() throws Exception {
        final List<Object> chemWeightFrac = Collections.singletonList(ccdChemicalWeightFractions);

        when(chemWeightRepository.findByDtxsid("DTXSID7020182")).thenReturn(chemWeightFrac);

        mockMvc.perform(get("/exposure/ccd/chem-weight-fractions/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(ccdChemicalWeightFractions.getDtxsid()));

    }
    
    @Test
    void testGetGeneralUseKeywordsByDtxsid() throws Exception {
        final List<Object> keywords = Collections.singletonList(ccdGeneralUseKeywords);

        when(keywordsRepository.findByDtxsid("DTXSID7020182")).thenReturn(keywords);

        mockMvc.perform(get("/exposure/ccd/keywords/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(ccdGeneralUseKeywords.getDtxsid()));

    }
    
    @Test
    void testGetProductUseCategoryByDtxsid() throws Exception {
        final List<Object> productUse = Collections.singletonList(ccdProductUseCategory);

        when(productUseRepository.findByDtxsid("DTXSID7020182")).thenReturn(productUse);

        mockMvc.perform(get("/exposure/ccd/puc/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(ccdProductUseCategory.getDtxsid()));

    }
    
    @Test
    void testGetReportedFunctionalUseByDtxsid() throws Exception {
        final List<Object> functionalUse = Collections.singletonList(ccdReportedFunctionalUse);

        when(functionalUseRepository.findByDtxsid("DTXSID7020182")).thenReturn(functionalUse);

        mockMvc.perform(get("/exposure/ccd/functional-use/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(ccdReportedFunctionalUse.getDtxsid()));

    }
    
    @Test
    void testGetProductionVolumeDataByDtxsid() throws Exception {
        final List<Object> productionVolume = Collections.singletonList(ccdProductionVolume);

        when(productionVolumeRepository.findByDtxsid("DTXSID7020182")).thenReturn(productionVolume);

        mockMvc.perform(get("/exposure/ccd/production-volume/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(ccdProductionVolume.getDtxsid()));

    }
}
