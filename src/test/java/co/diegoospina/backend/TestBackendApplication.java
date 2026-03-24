package co.diegoospina.backend;

import co.diegoospina.backend.shared.infrastructure.config.TestcontainersConfiguration;
import org.springframework.boot.SpringApplication;

public class TestBackendApplication {

    static void main(String[] args) {
        SpringApplication.from(BackendApplication::main)
            .with(TestcontainersConfiguration.class)
            .run(args);
    }

}
