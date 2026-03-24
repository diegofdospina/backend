package co.diegoospina.backend;

import co.diegoospina.backend.shared.infrastructure.config.TestcontainersConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

}
