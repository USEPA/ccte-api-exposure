package gov.epa.ccte.api.exposure.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import gov.epa.ccte.api.exposure.domain.GenExpoPrediction;

import static org.assertj.core.api.Assertions.*;

@Sql(
    scripts = {"/schema.sql", "/data.sql"},
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
    config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)
)
@DataJpaTest(properties = "spring.sql.init.mode=never")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class GenExpoPredictionRepositoryTest {

    @Autowired private GenExpoPredictionRepository repository;

    // Now test data loaded or not
    @Test
    void testDataLoaded() {
        assertThat(repository.findAll().size()).isEqualTo(2);
    }

    @Test
    void testGenExpoPredictionDataByDtxsid() {
        assertThat(repository.findByDtxsid("DTXSID7020182", GenExpoPrediction.class)).size().isEqualTo(1);

        assertThat(repository.findByDtxsid("DTXSID9020112", GenExpoPrediction.class)).size().isEqualTo(1);
    }

    @Test
    void testGenExpoPredictionDataByBatchDtxsid() {
        String[] dtxsids = {"DTXSID7020182","DTXSID9020112"};
        assertThat(repository.findByDtxsidInOrderByDtxsidAsc(dtxsids, GenExpoPrediction.class)).size().isEqualTo(2);
    }

    @Test
    void testGenExpoPredictionDataByDtxsidCcd() {
        assertThat(repository.findByDtxsid("DTXSID7020182")).size().isEqualTo(6);

        assertThat(repository.findByDtxsid("DTXSID9020112")).size().isEqualTo(6);
    }
}