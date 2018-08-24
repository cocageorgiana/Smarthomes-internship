package com.example.smarthomes.parallelprocessingservice.parallel;

import com.example.smarthomes.parallelprocessingservice.interpretor.PythonInterpretor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.script.ScriptException;
import java.io.IOException;
import java.util.concurrent.Future;

@Component
public class ParallelProcessor {

    /**
     * Process the output of the python script
     * @return An AsyncResult containing the python script
     * @throws InterruptedException
     * @throws IOException
     * @throws ScriptException
     */

    @Async("uiteExecutor")
    public Future<String> processingScript1() throws InterruptedException, IOException, ScriptException {

        Thread.sleep(500L);
        PythonInterpretor pythonInterpretor = new PythonInterpretor();

        return new AsyncResult<>(pythonInterpretor.processScript1());
    }

    /**
     * Process the output of the python script
     * @return An AsyncResult containing the python script
     * @throws InterruptedException
     * @throws IOException
     * @throws ScriptException
     */

    @Async("uiteExecutor")
    public Future<String> processingScript2() throws InterruptedException, IOException, ScriptException {

        Thread.sleep(500L);
        PythonInterpretor pythonInterpretor = new PythonInterpretor();

        return new AsyncResult<>(pythonInterpretor.processScript2());
    }

}
