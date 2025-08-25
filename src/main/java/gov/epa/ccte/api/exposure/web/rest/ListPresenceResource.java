package gov.epa.ccte.api.exposure.web.rest;

import gov.epa.ccte.api.exposure.domain.ListPresence;
import gov.epa.ccte.api.exposure.domain.ListPresenceTag;
import gov.epa.ccte.api.exposure.repository.ListPresenceRepository;
import gov.epa.ccte.api.exposure.repository.ListPresenceTagRepository;
import gov.epa.ccte.api.exposure.web.rest.error.HigherNumberOfDtxsidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@RestController
public class ListPresenceResource implements ListPresenceApi {
    final private ListPresenceRepository listPresenceRepository;
    final private ListPresenceTagRepository listPresenceTagRepository;

    @Value("200")
    private Integer batchSize;

    public ListPresenceResource(ListPresenceRepository listPresenceRepository, ListPresenceTagRepository listPresenceTagRepository) {
        this.listPresenceRepository = listPresenceRepository;
        this.listPresenceTagRepository = listPresenceTagRepository;
    }

    @Override
    public List<ListPresence> getListPresenceByDtxsid(String dtxsid) {
        log.debug("all functional use for dtxsid = {}", dtxsid);

        List<ListPresence> data = listPresenceRepository.findByDtxsid(dtxsid);

        return data;
    }

    @Override
    public List<ListPresenceTag> getListPresenceTags(){
        log.debug("all functional use category");
        List<ListPresenceTag> data = listPresenceTagRepository.findAll();
        return data;
    }

    @Override
    public @ResponseBody
    List<ListPresence>batchSearchListPresence(String[] dtxsids) {
        log.debug("list presence data for dtxsid size = {}", dtxsids.length);

        if(dtxsids.length > batchSize)
            throw new HigherNumberOfDtxsidException(dtxsids.length, batchSize);

        List<ListPresence> data = listPresenceRepository.findByDtxsidInOrderByDtxsidAsc(dtxsids, ListPresence.class);

        return data;
    }
}
