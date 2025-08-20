package gov.epa.ccte.api.exposure.web.rest;

import org.junit.jupiter.api.BeforeEach;

//This will test REST end-points in the GenExpoPredictionDataResource.java using WebMvcTest and MockitoBean

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

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;
import gov.epa.ccte.api.exposure.projection.CCDGenExpoPrediction;
import gov.epa.ccte.api.exposure.repository.GenExpoPredictionRepository;

import java.math.BigDecimal;
import java.util.*;

@ActiveProfiles("test")
@WebMvcTest(GenExpoPredictionResource.class)
@RunWith(MockitoJUnitRunner.class)
class GenExpoPredictionResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private GenExpoPredictionRepository genExpoPredictionRepository;

    private GenExpoPrediction genExpoPrediction;
    private CCDGenExpoPrediction ccdGenExpoPrediction;
    private ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    @BeforeEach
    void setUp(){
    	genExpoPrediction = GenExpoPrediction.builder()
                .dtxsid("DTXSID7020182")
                .productionVolume(BigDecimal.valueOf(2780000))
                .units("kg/day")
                .stockholmConvention(0)
                .probabilityDietary(BigDecimal.valueOf(1))
                .probabilityResidential(BigDecimal.valueOf(1))
                .probabilityPesticde(BigDecimal.valueOf(0))
                .probabilityIndustrial(BigDecimal.valueOf(0))
                .build();
    	
    	ccdGenExpoPrediction = factory.createProjection(CCDGenExpoPrediction.class);
    	ccdGenExpoPrediction.setValue((double) 2780000);
    	ccdGenExpoPrediction.setUnits("kg/day");
    	ccdGenExpoPrediction.setPredictor("Production Volume");

    }
    

    @Test
    void testGetGenExpoPredictionByDtxsid() throws Exception {
        final List<GenExpoPrediction> genExpo = Collections.singletonList(genExpoPrediction);

        when(genExpoPredictionRepository.findByDtxsid("DTXSID7020182",GenExpoPrediction.class)).thenReturn(genExpo);

        mockMvc.perform(get("/exposure/seem/general/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(genExpoPrediction.getDtxsid()));

    }
    
    @Test
    void testGetGenExpoPredictionByDtxsidCCD() throws Exception {
        final List<CCDGenExpoPrediction> genExpo = Collections.singletonList(ccdGenExpoPrediction);

        when(genExpoPredictionRepository.findByDtxsid("DTXSID7020182")).thenReturn(genExpo);

        mockMvc.perform(get("/exposure/seem/general/search/by-dtxsid/{dtxsid}", "DTXSID7020182")
        		.param("projection", "ccd-general"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].predictor").value(ccdGenExpoPrediction.getPredictor()));

    }
    
    @Test
    void testBatchSearchGenExpoPrediction() throws Exception {
    	final List<GenExpoPrediction> genExpo = Collections.singletonList(genExpoPrediction);
        String[] jsonArray = {"DTXSID7020182"};
        String jsonBody = new ObjectMapper().writeValueAsString(jsonArray);
        		
        when(genExpoPredictionRepository.findByDtxsidInOrderByDtxsidAsc(jsonArray, GenExpoPrediction.class)).thenReturn(genExpo);
        
        
        mockMvc.perform(post("/exposure/seem/general/search/by-dtxsid/")
        		.accept(MediaType.APPLICATION_JSON)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(jsonBody))
        		.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(genExpoPrediction.getDtxsid()))
                .andReturn();

    }
    
}
