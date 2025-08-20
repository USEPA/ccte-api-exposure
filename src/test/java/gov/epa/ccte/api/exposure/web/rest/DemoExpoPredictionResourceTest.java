package gov.epa.ccte.api.exposure.web.rest;

import org.junit.jupiter.api.BeforeEach;

//This will test REST end-points in the DemoExpoPredictionDataResource.java using WebMvcTest and MockitoBean

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import gov.epa.ccte.api.exposure.domain.DemoExpoPrediction;
import gov.epa.ccte.api.exposure.projection.CCDDemoExpoPrediction;
import gov.epa.ccte.api.exposure.repository.DemoExpoPredictionRepository;

import java.util.*;

@ActiveProfiles("test")
@WebMvcTest(DemoExpoPredictionResource.class)
@RunWith(MockitoJUnitRunner.class)
class DemoExpoPredictionResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private DemoExpoPredictionRepository demoExpoPredictionRepository;

    private DemoExpoPrediction demoExpoPrediction;
    private CCDDemoExpoPrediction ccdDemoExpoPrediction;
    private ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    @BeforeEach
    void setUp(){
    	demoExpoPrediction = DemoExpoPrediction.builder()
                .id(488214)
                .dtxsid("DTXSID7020182")
                .demographic("Total")
                .predictor("SEEM3 Consensus")
                .median(0.00005497)
                .medianText("5.497e-05")
                .l95(1.923e-7)
                .l95Text("1.923e-07")
                .units("mg/kg/day")
                .ad(1)
                .reference("Ring 2018")
                .build();
    	
    	ccdDemoExpoPrediction = factory.createProjection(CCDDemoExpoPrediction.class);
    	ccdDemoExpoPrediction.setUnits("mg/kg/day");
    	ccdDemoExpoPrediction.setDemographic("Total");
    	ccdDemoExpoPrediction.setMedian(0.00005497);
    	ccdDemoExpoPrediction.setPredictor("SEEM3 Consensus");
    	ccdDemoExpoPrediction.setU95(0.02044);
    }
    

    @Test
    void testGetDemoExpoPredictionByDtxsid() throws Exception {
        final List<DemoExpoPrediction> demoExpo = Collections.singletonList(demoExpoPrediction);

        when(demoExpoPredictionRepository.findByDtxsid("DTXSID7020182",DemoExpoPrediction.class)).thenReturn(demoExpo);

        mockMvc.perform(get("/exposure/seem/demographic/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(demoExpoPrediction.getDtxsid()));

    }
    
    @Test
    void testGetDemoExpoPredictionByDtxsidCCD() throws Exception {
        final List<CCDDemoExpoPrediction> demoExpo = Collections.singletonList(ccdDemoExpoPrediction);

        when(demoExpoPredictionRepository.findByDtxsid("DTXSID7020182")).thenReturn(demoExpo);

        mockMvc.perform(get("/exposure/seem/demographic/search/by-dtxsid/{dtxsid}", "DTXSID7020182")
        		.param("projection", "ccd-demographic"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].predictor").value(ccdDemoExpoPrediction.getPredictor()));

    }
    
    @Test
    void testBatchSearchDemoExpoPrediction() throws Exception {
    	final List<DemoExpoPrediction> demoExpo = Collections.singletonList(demoExpoPrediction);
        String[] jsonArray = {"DTXSID7020182"};
        String jsonBody = new ObjectMapper().writeValueAsString(jsonArray);
        		
        when(demoExpoPredictionRepository.findByDtxsidInOrderByDtxsidAsc(jsonArray, DemoExpoPrediction.class)).thenReturn(demoExpo);
        
        
        mockMvc.perform(post("/exposure/seem/demographic/search/by-dtxsid/")
        		.accept(MediaType.APPLICATION_JSON)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(jsonBody))
        		.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(demoExpoPrediction.getDtxsid()))
                .andReturn();

    }
    
}