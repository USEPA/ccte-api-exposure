package gov.epa.ccte.api.exposure.repository;

import gov.epa.ccte.api.exposure.projection.QsurDataAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;

import static org.assertj.core.api.Assertions.*;

@Sql(
    scripts = {"/schema.sql", "/data.sql"},
    executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
    config = @SqlConfig(transactionMode = SqlConfig.TransactionMode.ISOLATED)
)
@DataJpaTest(properties = "spring.sql.init.mode=never")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class QsurDataRepositoryTest {

    @Autowired private QsurDataRepository repository;

    // Now test data loaded or not
    @Test
    void testDataLoaded() {
        assertThat(repository.findAll().size()).isEqualTo(6);
    }

    @Test
    void testQsurDataByDtxsid() {
        assertThat(repository.findByDtxsidOrderByHarmonizedFunctionalUseAsc("DTXSID7020182", QsurDataAll.class)).size().isEqualTo(5);

        assertThat(repository.findByDtxsidOrderByHarmonizedFunctionalUseAsc("DTXSID9020112", QsurDataAll.class)).size().isEqualTo(1);
    }
}