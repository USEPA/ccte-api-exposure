package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ProductData;
import gov.epa.ccte.api.exposure.domain.Puc;
import gov.epa.ccte.api.exposure.repository.ProductDataRepository;
import gov.epa.ccte.api.exposure.repository.PucRepository;
import gov.epa.ccte.api.exposure.web.rest.error.HigherNumberOfDtxsidException;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class ProductDataResource implements ProductDataApi {

    final private ProductDataRepository productDataRepository;
    final private PucRepository pucRepository;

    @Value("200")
    private Integer batchSize;

    public ProductDataResource(ProductDataRepository productDataRepository, PucRepository pucRepository) {
        this.productDataRepository = productDataRepository;
        this.pucRepository = pucRepository;
    }

    @Override
    public List<ProductData> getProductDataByDtxsid(@Parameter(required = true, description = "DSSTox Substance Identifier", example = "DTXSID0020232") @PathVariable("dtxsid") String dtxsid) {
        log.debug("product data for dtxsid = {}", dtxsid);

       return productDataRepository.findByDtxsid(dtxsid);

    }

    @Override
    public @ResponseBody
    List<ProductData>batchSearchProductData(String[] dtxsids) {
        log.debug("product data for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<ProductData> data = productDataRepository.findByDtxsidInOrderByDtxsidAsc(dtxsids, ProductData.class);

        return data;
    }

    @Override
    public List<Puc> getProductDataPuc(){
        log.debug("all puc values");

        List<Puc> data = pucRepository.findAll();
        return data;
    }


}
