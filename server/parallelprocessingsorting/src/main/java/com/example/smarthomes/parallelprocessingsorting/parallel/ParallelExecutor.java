package com.example.smarthomes.parallelprocessingsorting.parallel;

import com.example.smarthomes.parallelprocessingsorting.interpretor.PythonInterpretor;
import com.example.smarthomes.parallelprocessingsorting.sorting.SortingAlgorithms;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.script.ScriptException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class ParallelExecutor {

    private final ParallelProcessor parallelProcessor;

    private static final Logger logger = Logger.getLogger(ParallelExecutor.class);

    @Autowired
    public ParallelExecutor(ParallelProcessor parallelProcessor) {
        this.parallelProcessor = parallelProcessor;
    }

    @PostConstruct
    public void execute() throws InterruptedException, ScriptException, IOException, ExecutionException {
        Long timeOfStart = System.currentTimeMillis();

        List<Future> futureList = new ArrayList<>();

        futureList.add(parallelProcessor.processingScript1());
        futureList.add(parallelProcessor.processingScript2());

        for(Future future : futureList) {
            logger.info(future.get());
            future.get();
        }

        logger.info("Time with parallel processing: " + String.valueOf(System.currentTimeMillis() - timeOfStart));


        Long timeOfStart2 = System.currentTimeMillis();
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        PythonInterpretor pythonInterpretor = new PythonInterpretor();
        List<String> resultList = new ArrayList<>();

        resultList.add(sortingAlgorithms.selectionSort(pythonInterpretor.processScript1()));
        resultList.add(sortingAlgorithms.selectionSort(pythonInterpretor.processScript2()));

        for(String string : resultList) {
            Thread.sleep(500L);
            logger.info(string);
        }

        logger.info("Time with normal processing " + String.valueOf(System.currentTimeMillis() - timeOfStart2));

    }
}
