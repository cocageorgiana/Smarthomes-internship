package com.example.smarthomes.quartzservice.job;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

    Logger logger = Logger.getLogger(SimpleJob.class);

    /**
     * Configured a basic job that will print a message
     * @param jobExecutionContext The context of the job
     * @throws JobExecutionException
     */

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        logger.info(String.format(jobExecutionContext.getJobDetail().getKey().getName(), jobExecutionContext.getFireTime()));
        System.out.println("Hello");
    }
}
