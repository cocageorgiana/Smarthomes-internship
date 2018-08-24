package com.example.smarthomes.quartzservice.scheduler;

import com.example.smarthomes.quartzservice.config.AutoWiringSpringBeanJobFactory;
import com.example.smarthomes.quartzservice.job.SimpleJob;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import java.io.IOException;

@Configuration
@ConditionalOnExpression("'${using.spring.schedulerFactory}'=='true'")
public class JobScheduler {

    private final ApplicationContext applicationContext;

    @Autowired
    public JobScheduler(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * Using the supported BeanJobFactory of the Quartz we created a bean in which we have a factory that is instantiated using the config class in order to give the ability to
     * inject properties using @Autowired
     * @return The configured bean
     */

    @Bean
    public SpringBeanJobFactory springBeanJobFactory() {
        AutoWiringSpringBeanJobFactory jobFactory = new AutoWiringSpringBeanJobFactory();

        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    /**
     * Implemented a basic scheduler that will execute the jobs created after the triggers fire
     * @param trigger The trigger that needs to be fired in order to execute the jobs
     * @param simpleJob The job details of the job that needs to be executed
     * @return A bean that executes the jobs
     * @throws IOException
     * @throws SchedulerException
     */

    public SchedulerFactoryBean scheduler(Trigger trigger, JobDetail simpleJob) throws IOException, SchedulerException {

        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setConfigLocation(new ClassPathResource("quartz.properties"));

        schedulerFactoryBean.setJobFactory(springBeanJobFactory());
        schedulerFactoryBean.setJobDetails(simpleJob);
        schedulerFactoryBean.setTriggers(trigger);

        return schedulerFactoryBean;
    }

    /**
     * A bean that defined the details for a job
     * @return
     */

    @Bean
    public JobDetailFactoryBean jobDetail() {

        JobDetailFactoryBean jobDetailFactory = new JobDetailFactoryBean();
        jobDetailFactory.setJobClass(SimpleJob.class);
        jobDetailFactory.setName("Qrtz_Job_Detail");
        jobDetailFactory.setDescription("Invoke Sample Job service...");
        jobDetailFactory.setDurability(true);
        return jobDetailFactory;
    }

    /**
     * A basic trigger that will fire each second , when it fires the scheduler will execute the jobs
     * @param job The job that needs to be executed
     * @return The actual trigger
     */

    @Bean
    public SimpleTriggerFactoryBean trigger(JobDetail job) {

        SimpleTriggerFactoryBean trigger = new SimpleTriggerFactoryBean();
        trigger.setJobDetail(job);

        int frequencyInSec = 1;

        trigger.setRepeatInterval(frequencyInSec * 1000);
        trigger.setRepeatCount(SimpleTrigger.REPEAT_INDEFINITELY);
        trigger.setName("Qrtz_Trigger");
        return trigger;

    }

}
