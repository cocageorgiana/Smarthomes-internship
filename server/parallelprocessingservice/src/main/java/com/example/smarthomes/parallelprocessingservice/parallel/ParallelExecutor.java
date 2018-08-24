package com.example.smarthomes.parallelprocessingservice.parallel;

import com.example.smarthomes.parallelprocessingservice.interpretor.PythonInterpretor;
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

    /**
     * Executes in both, asynchronous and synchronous way the outputs of the 2 python scripts. For the asynchronous way we insert in a List of Future data type the output. At the end
     * a comparision regarding the times of the 2 processing methods is printed and compared for learning purposes
     * @throws InterruptedException
     * @throws ScriptException
     * @throws IOException
     * @throws ExecutionException
     */

    @PostConstruct
    public void execute() throws InterruptedException, ScriptException, IOException, ExecutionException {

        Long timeOfStart = System.currentTimeMillis();

        List<Future> futureList = new ArrayList<>();

        futureList.add(parallelProcessor.processingScript1());
        futureList.add(parallelProcessor.processingScript2());

        for(Future future  : futureList) {
            logger.info(future.get());
            /*System.out.println(future.get());*/
            future.get();
        }

        logger.info("Time with parallel processing: " + String.valueOf(System.currentTimeMillis() - timeOfStart));
        logger.info("Normal processing");

        timeOfStart = System.currentTimeMillis();
        PythonInterpretor pythonInterpretor = new PythonInterpretor();

        List<String> someList = new ArrayList<>();
        someList.add(pythonInterpretor.processScript1());
        someList.add(pythonInterpretor.processScript2());

        for(String e : someList) {
            System.out.println(e);
        }

        logger.info("Time with simple processing: " + String.valueOf(System.currentTimeMillis() - timeOfStart));

    }
}
