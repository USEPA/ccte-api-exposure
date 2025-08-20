package gov.epa.ccte.api.exposure.web.rest;


//This will test REST end-points in the HttkDataResource.java using WebMvcTest and MockitoBean

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fasterxml.jackson.databind.ObjectMapper;

import gov.epa.ccte.api.exposure.domain.HttkData;
import gov.epa.ccte.api.exposure.repository.HttkDataRepository;


@ActiveProfiles("test")
@WebMvcTest(HttkDataResource.class)
@RunWith(MockitoJUnitRunner.class)
public class HttkDataResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private HttkDataRepository httkDataRepository;


    private HttkData httkData;
    
    @BeforeEach
    void setUp(){
        httkData = HttkData.builder()
                .id(101171)
                .dtxsid("DTXSID7020182")
                .parameter("Css")
                .measuredText("0.0083")
                .measured(BigDecimal.valueOf(0.0083))
                .predictedText("1.114")
                .predicted(BigDecimal.valueOf(1.114))
                .units("mg/L")
                .model("PBTK")
                .reference("Wambaugh et al. (2018)")
                .percentile("95%")
                .species("Rat")
                .dataSourceSpecies("Rat")
                .build();
    }
    
    @Test
    void testGetHttkDataByDtxsid() throws Exception {
        final List<HttkData> httk = Collections.singletonList(httkData);

        when(httkDataRepository.findByDtxsid("DTXSID7020182")).thenReturn(httk);

        mockMvc.perform(get("/exposure/httk/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(httkData.getDtxsid()));

    }
    
    @Test
    void testBatchSearchHttk() throws Exception {
    	final List<HttkData> httk = Collections.singletonList(httkData);
        String[] jsonArray = {"DTXSID7020182"};
        String jsonBody = new ObjectMapper().writeValueAsString(jsonArray);
        		
        when(httkDataRepository.findByDtxsidInOrderByDtxsidAsc(jsonArray, HttkData.class)).thenReturn(httk);
        
        
        mockMvc.perform(post("/exposure/httk/search/by-dtxsid/")
        		.accept(MediaType.APPLICATION_JSON)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(jsonBody))
        		.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(httkData.getDtxsid()))
                .andReturn();

    }
}
