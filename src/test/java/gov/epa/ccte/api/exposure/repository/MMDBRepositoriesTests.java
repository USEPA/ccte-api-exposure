package gov.epa.ccte.api.exposure.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import gov.epa.ccte.api.exposure.projection.MMDBMediaDescSummary;

import static org.assertj.core.api.Assertions.*;

@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DataJpaTest(properties = "spring.sql.init.mode=never")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class MMDBRepositoriesTests {

    @Autowired
    private MMDBAggregateRepository aggregate;
    @Autowired
    private MMDBSingleSampleRepository singleSample;
    @Autowired
    private MMDBMediaDescRepository descriptions;

    @Test
    void testDataLoaded(){
        assertThat(aggregate.findAll().size()).isEqualTo(10);
        assertThat(singleSample.findAll().size()).isEqualTo(10);
        assertThat(descriptions.findAll().size()).isEqualTo(10);
    }

    // MMDBAggregateRepository
    @Test
    void testMMDBAggregateFindByDtxsid(){
       assertThat(aggregate.findByDtxsid("DTXSID7020182")).size().isEqualTo(5);

       assertThat(aggregate.findByDtxsid("DTXSID9020112")).size().isEqualTo(5);
    }

    @Test
    void testMMDBAggregateFindByMedium(){
       Integer pageSize = 10;
       Integer pageNumber = 1;
       Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
       assertThat(aggregate.findByHarmonizedMediumOrderByIdAsc("surface water", pageable)).size().isEqualTo(2);
    }

    // MMDBSingleSampleRepository
    @Test
    void testSingleSampleFindByDtxsid(){
       assertThat(singleSample.findByDtxsid("DTXSID7020182")).size().isEqualTo(5);

       assertThat(singleSample.findByDtxsid("DTXSID9020112")).size().isEqualTo(5);
    }

    @Test
    void testSingleSampleFindByMedium(){
       Integer pageSize = 10;
       Integer pageNumber = 1;
       Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
       assertThat(singleSample.findByHarmonizedMediumOrderByIdAsc("surface water", pageable)).size().isEqualTo(7);
    }

    // MMDBMediaDescRepository
    @Test
    void testProductionVolumeByDtxsid(){
       assertThat(descriptions.findBy(MMDBMediaDescSummary.class)).size().isEqualTo(10);
    }
}