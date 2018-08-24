package com.example.smarthomes.parallelprocessingsorting.parallel;

import com.example.smarthomes.parallelprocessingsorting.interpretor.PythonInterpretor;
import com.example.smarthomes.parallelprocessingsorting.sorting.SortingAlgorithms;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.concurrent.Future;

@Component
public class ParallelProcessor {

    @Async("uiteExecutor")
    public Future<String> processingScript1() throws InterruptedException, IOException, ScriptException {
        Thread.sleep(500L);

        PythonInterpretor pythonInterpretor = new PythonInterpretor();
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

        return new AsyncResult<>(sortingAlgorithms.heapSort(pythonInterpretor.processScript1()));
    }


    @Async("uiteExecutor")
    public Future<String> processingScript2() throws InterruptedException, IOException, ScriptException {
        Thread.sleep(500L);

        PythonInterpretor pythonInterpretor = new PythonInterpretor();
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

        return new AsyncResult<>(sortingAlgorithms.heapSort(pythonInterpretor.processScript2()));
    }
}
