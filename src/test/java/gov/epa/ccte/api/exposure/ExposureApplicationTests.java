package gov.epa.ccte.api.exposure;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThatCode;

@SpringBootTest
@ActiveProfiles("test")
class ExposureApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void applicationStarts() {
        assertThatCode(() -> ExposureApplication.main(new String[]{})).doesNotThrowAnyException();
    }
}