package de.bsi.thymeleaf.virtual_thread;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
// @ActiveProfiles("virtual") // Virtual threads enabled in application.properties
class ThreadInfoControllerTest {

    // To see a difference in performance set REQUESTS to 5000
    private static final int REQUESTS = 5;
    private final RestTemplate client = new RestTemplate();

    @Test
    void loadTestWithVirtualThreads() throws Exception {
    	var before = System.currentTimeMillis();
    	try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.range(0, REQUESTS).forEach(i -> executor.submit(() -> {
                var resp = client.getForObject("http://localhost:8080/thread", ThreadInfo.class);
                System.out.println("Completed: " + resp.toString());
            }));
        }
        System.out.println("All requests send away after ms: "
                + (System.currentTimeMillis() - before));
    }

}