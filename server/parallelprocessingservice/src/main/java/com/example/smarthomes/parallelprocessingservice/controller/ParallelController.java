package com.example.smarthomes.parallelprocessingservice.controller;

import com.example.smarthomes.parallelprocessingservice.parallel.ParallelExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@RestController
public class ParallelController {

    private ParallelExecutor parallelExecutor;

    public ParallelController(ParallelExecutor parallelExecutor) {
        this.parallelExecutor = parallelExecutor;
    }

    @GetMapping(value = "parallel")
    public void someController() throws InterruptedException, IOException, ExecutionException, ScriptException {
        parallelExecutor.execute();
    }
}
