package gov.epa.ccte.api.exposure.web.rest;

import org.junit.jupiter.api.BeforeEach;

//This will test REST end-points in the ListPresenceResource.java using WebMvcTest and MockitoBean

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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;

import gov.epa.ccte.api.exposure.domain.ListPresence;
import gov.epa.ccte.api.exposure.domain.ListPresenceTag;
import gov.epa.ccte.api.exposure.repository.ListPresenceRepository;
import gov.epa.ccte.api.exposure.repository.ListPresenceTagRepository;


import java.util.*;

@ActiveProfiles("test")
@WebMvcTest({ListPresenceResource.class})
@RunWith(MockitoJUnitRunner.class)
class ListPresenceResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private ListPresenceRepository listPresenceRepository;
    
    @MockitoBean
    private ListPresenceTagRepository listPresenceTagRepository;


    private ListPresence listPresence;
    private ListPresenceTag listPresenceTag;

    @BeforeEach
    void setUp(){
    	listPresence = ListPresence.builder()
    			.id(24597L)
                .dtxsid("DTXSID7020182")
                .docid(1371471)
                .doctitle("The 25 Chemicals Found in All Nine of the Biosolids Studied")
                .docsubtitle("median concentrations are normalized to organic carbon and are given in micorgrams per kilogram of organic carbon (µg/kg OC)")
                .docdate("")
                .organization("USGS")
                .reportedfunction("fire retardant")
                .functioncategory("Flame retardant")
                .component("")
                .keywordset("detected; wastewater")
                .build();
    	
    	listPresenceTag = ListPresenceTag.builder()
    			.id(46L)
                .tagName("Cleaning products and household care - shoes")
                .tagDefinition("Products related to the care of footwear which do not fit into a more refined category")
                .tagKind("PUC - formulation")
                .build();

    }
    

    @Test
    void testGetListPresenceByDtxsid() throws Exception {
        final List<ListPresence> presence = Collections.singletonList(listPresence);

        when(listPresenceRepository.findByDtxsid("DTXSID7020182")).thenReturn(presence);

        mockMvc.perform(get("/exposure/list-presence/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(listPresence.getDtxsid()));

    }
    
    @Test
    void testGetListPresenceTags() throws Exception {
        final List<ListPresenceTag> tag = Collections.singletonList(listPresenceTag);

        when(listPresenceTagRepository.findAll()).thenReturn(tag);

        mockMvc.perform(get("/exposure/list-presence/tags"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].tagName").value(listPresenceTag.getTagName()));
    }
    
    @Test
    void testBatchSearchListPresence() throws Exception {
    	final List<ListPresence> presence = Collections.singletonList(listPresence);
        String[] jsonArray = {"DTXSID7020182"};
        String jsonBody = new ObjectMapper().writeValueAsString(jsonArray);
        		
        when(listPresenceRepository.findByDtxsidInOrderByDtxsidAsc(jsonArray, ListPresence.class)).thenReturn(presence);
        
        
        mockMvc.perform(post("/exposure/list-presence/search/by-dtxsid/")
        		.accept(MediaType.APPLICATION_JSON)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(jsonBody))
        		.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(listPresence.getDtxsid()))
                .andReturn();

    }
    
}
