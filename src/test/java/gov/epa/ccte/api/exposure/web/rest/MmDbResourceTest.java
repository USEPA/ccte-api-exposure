package gov.epa.ccte.api.exposure.web.rest;

import org.junit.jupiter.api.BeforeEach;

//This will test REST end-points in the MmDbResource.java using WebMvcTest and MockitoBean

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

import gov.epa.ccte.api.exposure.domain.MMDBAggregate;
import gov.epa.ccte.api.exposure.domain.MMDBSingleSample;
import gov.epa.ccte.api.exposure.projection.MMDBMediaDescSummary;
import gov.epa.ccte.api.exposure.repository.MMDBAggregateRepository;
import gov.epa.ccte.api.exposure.repository.MMDBMediaDescRepository;
import gov.epa.ccte.api.exposure.repository.MMDBSingleSampleRepository;
import gov.epa.ccte.api.exposure.service.MMDBService;
import gov.epa.ccte.api.exposure.web.rest.requests.MMDBPage;

import java.time.LocalDate;
import java.util.*;

@ActiveProfiles("test")
@WebMvcTest(MmDbResource.class)
@RunWith(MockitoJUnitRunner.class)

public class MmDbResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private MMDBAggregateRepository mmdbAggregateRepository;
    @MockitoBean
    private MMDBMediaDescRepository mmdbMediaDescRepository;
    @MockitoBean
    private MMDBSingleSampleRepository mmdbSingleSampleRepository;
    @MockitoBean
    private MMDBService mmdbService;
    
    private MMDBAggregate mmdbAggregate;
    private MMDBSingleSample mmdbSingleSample;
    private MMDBMediaDescSummary mmdbMediaDescSummary;
    private MMDBPage aggregateResults;
    private MMDBPage singleSampleResults;
    private ProjectionFactory factory = new SpelAwareProxyProjectionFactory();
    
    @BeforeEach
    void setUp(){
    	mmdbAggregate = MMDBAggregate.builder()
    			.id(11628881L)
    			.fullSourceName("Biomonitoring California")
    			.chemicalName("Bisphenol A (BPA)")
                .dtxsid("DTXSID7020182")
                .preferredName("Bisphenol A")
                .casrn("80-05-7")
                .result("1.27")
                .units("µg/L")
                .cleanedUnits("µg/L")
                .statistic("50th")
    			.sampleSize("89")
    			.lod("0.2")
                .loq(null)
                .numDetects(null)
                .numNonDetects(null)
                .rateDetects(null)
                .detected(null)
                .detectedConflict(0)
                .notesDetects(null)
                .species(null)
    			.media("Urine")
    			.harmonizedMedium("human blood (whole/serum/plasma)")
                .population("Pregnant women")
                .subPopulation(null)
                .collectionActivityId("Maternal and Infant Environmental Exposure Project (MIEEP)")
                .dates(null)
                .years("2011")
                .location(null)
                .stateOrProvince("CA")
    			.county(null)
                .country("United States")
                .qualityFlag(null)
                .link(null)
                .reference(null)
                .version("v1.1")
                .exportDate(LocalDate.of(2025,01,29))
                .CASNumber(null)
                .build();
    	
    	mmdbSingleSample = MMDBSingleSample.builder()
    			.id(68636743L)
    			.fullSourceName("USGS Monitoring Data National Water Quality Monitoring Council - Air, Soil, Biological (Tissue), Sediment, Water")
    			.chemicalName("4,4'-Isopropylidenediphenol")
                .dtxsid("DTXSID7020182")
                .preferredName("Bisphenol A")
                .casrn("80-05-7")
                .result(null)
                .units("µg/L")
                .cleanedUnits("µg/L")
    			.lod(null)
                .loq("0.15")
                .detectionFlag("Not Detected")
                .resultFlag(null)
                .detected(0)
                .detectedConflict(0)
                .notesDetects("Unambiguous non-detect")
                .species(null)
    			.media("Water")
    			.harmonizedMedium("surface water")
                .method("EPA/NPS-EC Non-Volatile Waste Indicators in Water by Gas Chromatography-Mass Spectrometry")
                .collectionActivityId("11NPSWRD_WQX-CARE_3P_4954360-201007060915SR_B")
                .sampleId(null)
                .mmdbSampleId("168_106357")
                .dates("2010-07-06")
                .year("2010")
                .month(null)
                .time(null)
                .location("11NPSWRD_WQX-CARE_3P_4954360")
                .stateOrProvince("UT")
    			.county(null)
                .country("United States")
                .qualityFlag(null)
                .link(null)
                .reference("STORET")
                .version("v1.1")
                .exportDate(LocalDate.of(2025,01,29))
                .CASNumber(null)
                .build();
    	
        aggregateResults = MMDBPage.builder()
         	   .medium("human blood (whole/serum/plasma)")
                .data(Collections.singletonList(mmdbAggregate))
                .recordsOnPage(402)
                .totalRecords(402L)
                .pageNumber(1)
                .totalPages(1)
                .build();
        
        singleSampleResults = MMDBPage.builder()
          	   .medium("surface water")
                 .data(Collections.singletonList(mmdbSingleSample))
                 .recordsOnPage(402)
                 .totalRecords(402L)
                 .pageNumber(1)
                 .totalPages(1)
                 .build();
    	
    	mmdbMediaDescSummary = factory.createProjection(MMDBMediaDescSummary.class);
    	mmdbMediaDescSummary.setHarmonizedMedium("Outdoor ambient air");
    	mmdbMediaDescSummary.setHarmonizedMediumDesc("ambient air");

    }
    
    @Test
    void testGetHarmonizedAggregateDataByDtxsid() throws Exception {
        final List<MMDBAggregate> aggregateData = Collections.singletonList(mmdbAggregate);

        when(mmdbAggregateRepository.findByDtxsid("DTXSID7020182")).thenReturn(aggregateData);

        mockMvc.perform(get("/exposure/mmdb/aggregate/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(mmdbAggregate.getDtxsid()));

    }
    
    @Test
    void testGetHarmonizedAggregateDataByMedium() throws Exception {
        Integer pageNumber = 1;
        Integer pageSize = 10000;
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        
        when(mmdbService.getAllAggregateByMedium("human blood (whole/serum/plasma)", pageSize, pageNumber, pageable)).thenReturn(aggregateResults);

        mockMvc.perform(get("/exposure/mmdb/aggregate/by-medium")
        		.param("pageNumber", "1")
				.param("medium", "human blood (whole/serum/plasma)"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].harmonizedMedium").value(aggregateResults.getMedium()));

    }
    
    @Test
    void testGetHarmonizedSingleSampleDataByDtxsid() throws Exception {
        final List<MMDBSingleSample> singleSampleData = Collections.singletonList(mmdbSingleSample);

        when(mmdbSingleSampleRepository.findByDtxsid("DTXSID7020182")).thenReturn(singleSampleData);

        mockMvc.perform(get("/exposure/mmdb/single-sample/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(mmdbSingleSample.getDtxsid()));

    }
    
    @Test
    void testGetHarmonizedSingleSampleDataByMedium() throws Exception {
        Integer pageNumber = 1;
        Integer pageSize = 10000;
        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        
        when(mmdbService.getAllSingleSampleByMedium("surface water", pageSize, pageNumber, pageable)).thenReturn(singleSampleResults);

        mockMvc.perform(get("/exposure/mmdb/single-sample/by-medium")
        		.param("pageNumber", "1")
				.param("medium", "surface water"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.data[0].harmonizedMedium").value(singleSampleResults.getMedium()));

    }
    
    @Test
    void testGetAllHarmonizedMedia() throws Exception {
        final List<MMDBMediaDescSummary> media = Collections.singletonList(mmdbMediaDescSummary);

        when(mmdbMediaDescRepository.findBy(MMDBMediaDescSummary.class)).thenReturn(media);

        mockMvc.perform(get("/exposure/mmdb/mediums"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].harmonizedMedium").value(mmdbMediaDescSummary.getHarmonizedMedium()));

    }
   
    
}
