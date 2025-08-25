package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.HttkData;
import gov.epa.ccte.api.exposure.repository.HttkDataRepository;
import gov.epa.ccte.api.exposure.web.rest.error.HigherNumberOfDtxsidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class HttkDataResource implements HttkDataApi {
    final private HttkDataRepository httkDataRepository;

    @Value("200")
    private Integer batchSize;

    public HttkDataResource( HttkDataRepository httkDataRepository) {
        this.httkDataRepository = httkDataRepository;
    }

    @Override
    public List<HttkData> getHttkDataByDtxsid(String dtxsid) {
        log.debug("Httk Data by dtxsid = {}", dtxsid);

        return httkDataRepository.findByDtxsid(dtxsid);
    }

    @Override
    public @ResponseBody
    List<HttkData> batchSearchHttk(String[] dtxsids) {
        log.debug("demographic exposure prediction data for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<HttkData> data = httkDataRepository.findByDtxsidInOrderByDtxsidAsc(dtxsids, HttkData.class);

        return data;
    }
}
