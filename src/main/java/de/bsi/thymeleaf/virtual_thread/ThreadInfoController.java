package de.bsi.thymeleaf.virtual_thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ThreadInfoController {
	
	private Logger log = LoggerFactory.getLogger(ThreadInfoController.class);

    @GetMapping(value = "/thread", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThreadInfo logThreadInfo() throws InterruptedException {
        var threadInfo = ThreadInfo.create(Thread.currentThread());
        log.trace(threadInfo.toString());
        // Sleep to simulate work.
        Thread.sleep(2000L);
        return threadInfo;
    }

}
