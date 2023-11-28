package de.bsi.thymeleaf.virtual_thread;

import org.apache.coyote.ProtocolHandler;
import org.springframework.boot.web.embedded.tomcat.TomcatProtocolHandlerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.support.TaskExecutorAdapter;

import java.util.concurrent.Executors;

// Required only in Spring Boot version < 3.2.0
// @Configuration
public class ThreadConfig {
	
	@Bean
    @Profile("virtual")
    AsyncTaskExecutor applicationTaskExecutor() {
        return new TaskExecutorAdapter(Executors.newVirtualThreadPerTaskExecutor());
    }

    @Bean
    @Profile("virtual")
    TomcatProtocolHandlerCustomizer<ProtocolHandler> protocolHandlerVirtualThreadExecutorCustomizer() {
        return protocolHandler -> protocolHandler.setExecutor(
        		Executors.newVirtualThreadPerTaskExecutor());
    }

}
