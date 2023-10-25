package de.bsi.thymeleaf.virtual_thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("virtual")
class ThreadInfoControllerTest {

    private static final int REQUESTS = 5000;
    private final RestTemplate client = new RestTemplate();

    @Test
    void loadTestWithVirtualThreads() throws Exception {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            var before = System.currentTimeMillis();
            IntStream.range(0, REQUESTS).forEach(i -> executor.submit(() -> {
                var resp = client.getForObject("http://localhost:8080/thread", ThreadInfo.class);
                System.out.println("Completed: " + resp.toString());
            }));
            System.out.println("All requests send away after ms: "
                    + (System.currentTimeMillis() - before));
        }
    }

}