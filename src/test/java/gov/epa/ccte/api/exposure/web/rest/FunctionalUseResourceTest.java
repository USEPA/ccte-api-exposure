package gov.epa.ccte.api.exposure.web.rest;

import org.junit.jupiter.api.BeforeEach;

//This will test REST end-points in the FunctionalUseResource.java using WebMvcTest and MockitoBean

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

import gov.epa.ccte.api.exposure.domain.FunctionalUse;
import gov.epa.ccte.api.exposure.domain.FunctionalUseCategory;
import gov.epa.ccte.api.exposure.projection.QsurDataAll;
import gov.epa.ccte.api.exposure.repository.FunctionalUseRepository;
import gov.epa.ccte.api.exposure.repository.QsurDataRepository;
import gov.epa.ccte.api.exposure.repository.FunctionalUseCategoryRepository;

import java.math.BigDecimal;
import java.util.*;

@ActiveProfiles("test")
@WebMvcTest({FunctionalUseResource.class})
@RunWith(MockitoJUnitRunner.class)
class FunctionalUseResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private FunctionalUseRepository functionalUseRepository;
    @MockitoBean
    private FunctionalUseCategoryRepository functionalUseCategoryRepository;
    @MockitoBean
    private QsurDataRepository qsurDataRepository;
    
    private FunctionalUse functionalUse;
    private FunctionalUseCategory functionalUseCategory;
    private QsurDataAll qsurDataAll;
    private ProjectionFactory factory = new SpelAwareProxyProjectionFactory();

    @BeforeEach
    void setUp(){
    	functionalUse = FunctionalUse.builder()
    			.id(221677L)
                .dtxsid("DTXSID7020182")
                .datatype("Composition")
                .docid(1389221)
                .doctitle("drytek moisture vapor barrier")
                .docdate("2016-01-05")
                .reportedfunction("hardener")
                .functioncategory("Hardener")
                .build();
    	
    	functionalUseCategory = FunctionalUseCategory.builder()
    			.id(36L)
                .category("Deflocculant")
                .definition("Chemical substance used to fluidize concentrated slurries to reduce their bulk viscosity or stickiness in processing or handling. See closely related: anti-caking agent.")
                .build();
    	
    	qsurDataAll = factory.createProjection(QsurDataAll.class);
    	qsurDataAll.setProbability(BigDecimal.valueOf(0.3722));
    	qsurDataAll.setHarmonizedFunctionalUse("antimicrobial");
    	qsurDataAll.setDtxsid("DTXSID7020182");

    }
    

    @Test
    void testGetFunctionalUseByDtxsid() throws Exception {
        final List<FunctionalUse> functionalUseData = Collections.singletonList(functionalUse);

        when(functionalUseRepository.findByDtxsid("DTXSID7020182",FunctionalUse.class)).thenReturn(functionalUseData);

        mockMvc.perform(get("/exposure/functional-use/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(functionalUse.getDtxsid()));

    }
    
    @Test
    void testGetFunctionalUseCategory() throws Exception {
        final List<FunctionalUseCategory> categories = Collections.singletonList(functionalUseCategory);

        when(functionalUseCategoryRepository.findAll()).thenReturn(categories);

        mockMvc.perform(get("/exposure/functional-use/category"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].category").value(functionalUseCategory.getCategory()));
    }
    
    @Test
    void testGetFunctionalUseProbabilityByDtxsid() throws Exception {
        final List<QsurDataAll> qsurData = Collections.singletonList(qsurDataAll);

        when(qsurDataRepository.findByDtxsidOrderByHarmonizedFunctionalUseAsc("DTXSID7020182", QsurDataAll.class)).thenReturn(qsurData);

        mockMvc.perform(get("/exposure/functional-use/probability/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
        		.andExpect(jsonPath("$[0].dtxsid").value(qsurDataAll.getDtxsid()));

    }
    
    @Test
    void testBatchSearchFunctionalUse() throws Exception {
    	final List<FunctionalUse> functionalUseData = Collections.singletonList(functionalUse);
        String[] jsonArray = {"DTXSID7020182"};
        String jsonBody = new ObjectMapper().writeValueAsString(jsonArray);
        		
        when(functionalUseRepository.findByDtxsidInOrderByDtxsidAsc(jsonArray, FunctionalUse.class)).thenReturn(functionalUseData);
        
        
        mockMvc.perform(post("/exposure/functional-use/search/by-dtxsid/")
        		.accept(MediaType.APPLICATION_JSON)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(jsonBody))
        		.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(functionalUse.getDtxsid()))
                .andReturn();

    }
    
}