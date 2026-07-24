package gov.epa.ccte.api.exposure.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import gov.epa.ccte.api.exposure.domain.HttkData;

import static org.assertj.core.api.Assertions.*;

@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@DataJpaTest(properties = "spring.sql.init.mode=never")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class HttkDataRepositoryTest {

    @Autowired private HttkDataRepository repository;

    // Now test data loaded or not
    @Test
    void testDataLoaded() {
        assertThat(repository.findAll().size()).isEqualTo(10);
    }

    @Test
    void testHttkDataByDtxsid() {
        assertThat(repository.findByDtxsid("DTXSID7020182")).size().isEqualTo(5);

        assertThat(repository.findByDtxsid("DTXSID9020112")).size().isEqualTo(5);
    }

    @Test
    void testHttkDataByBatchDtxsid() {
        String[] dtxsids = {"DTXSID7020182","DTXSID9020112"};
        assertThat(repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, HttkData.class)).size().isEqualTo(10);
    }
}