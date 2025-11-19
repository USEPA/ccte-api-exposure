package gov.epa.ccte.api.exposure.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import gov.epa.ccte.api.exposure.domain.CCDBiomonitoring;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@Sql(scripts = {"/schema.sql", "/data.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Testcontainers
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CCDRepositoriesTests {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> pgsqldb = new PostgreSQLContainer<>("postgres:16-alpine");

    @Autowired
    private DataSource dataSource;
    @Autowired 
    private JdbcTemplate jdbcTemplate;
    @Autowired 
    private TestEntityManager entityManager;
    @Autowired 
    private CCDBiomonitoringRepository biomonitoring;
    @Autowired
    private	CCDChemicalWeightFractionsRepository weightFractions;
    @Autowired
    private CCDGeneralUseKeywordsRepository keywords;
    @Autowired 
    private CCDProductionVolumeRepository productionVolume;
    @Autowired
    private CCDProductUseCategoryRepository productUseCategory;
    @Autowired
    private CCDReportedFunctionalUseRepository functionalUse;
    

    @Test
    void connectionEstablished(){
        assertThat(pgsqldb.isCreated()).isTrue();
        assertThat(pgsqldb.isRunning()).isTrue();
    }

    @Test
    void injectedComponentsAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(biomonitoring).isNotNull();
        assertThat(weightFractions).isNotNull();
        assertThat(keywords).isNotNull();
        assertThat(productionVolume).isNotNull();
        assertThat(productUseCategory).isNotNull();
        assertThat(functionalUse).isNotNull();
    }
    
    @Test
    void testDataLoaded(){
        assertThat(biomonitoring.findAll().size()).isEqualTo(10);
        assertThat(weightFractions.findAll().size()).isEqualTo(10);
        assertThat(keywords.findAll().size()).isEqualTo(10);
        assertThat(productionVolume.findAll().size()).isEqualTo(4);
        assertThat(productUseCategory.findAll().size()).isEqualTo(10);
        assertThat(functionalUse.findAll().size()).isEqualTo(10);
    }
    
    // CCDBiomonitoringRepository
    @Test
    void testBiomonitoringFindByDtxsid(){
       assertThat(biomonitoring.findByDtxsid("DTXSID7020182", CCDBiomonitoring.class)).size().isEqualTo(5);
       assertThat(biomonitoring.findByDtxsidWithMsgColumn("DTXSID7020182")).size().isEqualTo(5);
       
       assertThat(biomonitoring.findByDtxsid("DTXSID9020112", CCDBiomonitoring.class)).size().isEqualTo(5);
       assertThat(biomonitoring.findByDtxsidWithMsgColumn("DTXSID9020112")).size().isEqualTo(5);
       
	}

    // CCDChemicalWeightFractionRepository
    @Test
    void testChemicalWeightFrationsFindByDtxsid(){
       assertThat(weightFractions.findByDtxsid("DTXSID7020182")).size().isEqualTo(5);
       
       assertThat(weightFractions.findByDtxsid("DTXSID9020112")).size().isEqualTo(5);
       
	}
    
    // CCDGeneralUseKeywordsRepository
    @Test
    void testKeywordsFindByDtxsid(){
       assertThat(keywords.findByDtxsid("DTXSID7020182")).size().isEqualTo(5);
       
       assertThat(keywords.findByDtxsid("DTXSID9020112")).size().isEqualTo(5);
       
	}
    
    // CCDProductionVolumeRepository
    @Test
    void testProductionVolumeByDtxsid(){
       assertThat(productionVolume.findByDtxsid("DTXSID7020182")).size().isEqualTo(4);
       
       assertThat(productionVolume.findByDtxsid("DTXSID9020112")).size().isEqualTo(0);
       
	}
    
    // CCDProductUseCategoryRepository
    @Test
    void testProductUseCategoryByDtxsid(){
       assertThat(productUseCategory.findByDtxsid("DTXSID7020182")).size().isEqualTo(5);
       
       assertThat(productUseCategory.findByDtxsid("DTXSID9020112")).size().isEqualTo(5);
       
	}
    
    // CCDReportedFunctionalUseRepository
    @Test
    void testReportedFunctionalUseByDtxsid(){
       assertThat(functionalUse.findByDtxsid("DTXSID7020182")).size().isEqualTo(5);
       
       assertThat(functionalUse.findByDtxsid("DTXSID9020112")).size().isEqualTo(5);
       
	}
}
