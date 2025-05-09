package es.uah.peliculasactores;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(properties = {
        "AZURE_BLOB_CONNECTION_STRING=dummy-value",
        "AZURE_BLOB_CONTAINER_NAME=dummy-container"
})
class PeliculasActoresApplicationTests {

    @Test
    void contextLoads() {
    }

}
