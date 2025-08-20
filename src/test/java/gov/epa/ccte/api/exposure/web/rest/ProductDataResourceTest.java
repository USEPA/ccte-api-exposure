package gov.epa.ccte.api.exposure.web.rest;

import org.junit.jupiter.api.BeforeEach;

//This will test REST end-points in the ProductDataResource.java using WebMvcTest and MockitoBean

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

import gov.epa.ccte.api.exposure.domain.ProductData;
import gov.epa.ccte.api.exposure.domain.Puc;
import gov.epa.ccte.api.exposure.repository.ProductDataRepository;
import gov.epa.ccte.api.exposure.repository.PucRepository;

import java.math.BigDecimal;
import java.util.*;

@ActiveProfiles("test")
@WebMvcTest(ProductDataResource.class)
@RunWith(MockitoJUnitRunner.class)
class ProductDataResourceTest {

    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private ProductDataRepository productDataRepository;

    @MockitoBean
    private PucRepository pucRepository;

    private ProductData productData;
    private Puc puc;

    @BeforeEach
    void setUp(){
        productData = ProductData.builder()
                .id(10934L)
                .dtxsid("DTXSID7020182")
                .docid(1308929)
                .doctitle("EPOLITE 2152 HARDENER")
                .docdate("03/09/1992")
                .productname("epolite 2152 hardener")
                .gencat("Raw Materials")
                .prodfam("adhesives")
                .prodtype("")
                .classificationmethod("Manual Batch")
                .rawmincomp("30")
                .rawmaxcomp("45")
                .rawcentralcomp("")
                .unittype("percent")
                .lowerweightfraction(BigDecimal.valueOf(0.300000000000000))
                .upperweightfraction(BigDecimal.valueOf(0.450000000000000))
                .centralweightfraction(null)
                .weightfractiontype("reported")
                .build();
        

        puc = Puc.builder()
                .id(25L)
                .kindName("Article")
                .genCat("Batteries")
                .prodfam("electronic device")
                .prodtype("camera")
                .definition("Electronic device batteries intended for cameras, including photo and video cameras. Includes replacement batteries for these devices.")
                .build();
    }

    @Test
    void testGetProductDataByDtxsid() throws Exception {
        final List<ProductData> products = Collections.singletonList(productData);

        when(productDataRepository.findByDtxsid("DTXSID7020182")).thenReturn(products);

        mockMvc.perform(get("/exposure/product-data/search/by-dtxsid/{dtxsid}", "DTXSID7020182"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(productData.getDtxsid()));

    }
    
    @Test
    void testBatchSearchProductData() throws Exception {
    	final List<ProductData> products = Collections.singletonList(productData);
        String[] jsonArray = {"DTXSID7020182"};
        String jsonBody = new ObjectMapper().writeValueAsString(jsonArray);
        		
        when(productDataRepository.findByDtxsidInOrderByDtxsidAsc(jsonArray, ProductData.class)).thenReturn(products);
        
        
        mockMvc.perform(post("/exposure/product-data/search/by-dtxsid/")
        		.accept(MediaType.APPLICATION_JSON)
        		.contentType(MediaType.APPLICATION_JSON)
        		.content(jsonBody))
        		.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].dtxsid").value(productData.getDtxsid()))
                .andReturn();

    }
    

    @Test
    void testGetProductDataPuc() throws Exception {
        final List<Puc> pucs = Collections.singletonList(puc);

        when(pucRepository.findAll()).thenReturn(pucs);

        mockMvc.perform(get("/exposure/product-data/puc"))
				.andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(puc.getId()));

    }
}