package de.bsi.thymeleaf.virtual_thread;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.bsi.thymeleaf.ItemController;

@RestController("/thread")
public class ThreadInfoController {

    @GetMapping(value = "/thread", produces = MediaType.APPLICATION_JSON_VALUE)
    public ThreadInfo logThreadInfo() throws InterruptedException {
        var threadInfo = ThreadInfo.create(Thread.currentThread());
        LoggerFactory.getLogger(ItemController.class).trace(threadInfo.toString());
        // Sleep to simulate work.
        Thread.sleep(2000L);
        return threadInfo;
    }

}
