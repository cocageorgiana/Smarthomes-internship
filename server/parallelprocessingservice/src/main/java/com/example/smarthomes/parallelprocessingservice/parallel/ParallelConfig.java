package com.example.smarthomes.parallelprocessingservice.parallel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ParallelConfig {

    /**
     * Defined a configuration bean in which we instantiate a ThreadPoolExecutor object and configure it
     * @return The configured ThreadPoolExecutor object
     */

    @Bean(name = "uiteExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(8);
        executor.setMaxPoolSize(16);
        executor.setThreadNamePrefix("MyExecutor-" + Thread.currentThread().getName());
        executor.setWaitForTasksToCompleteOnShutdown(true);
        executor.initialize();
        return executor;
    }
}
