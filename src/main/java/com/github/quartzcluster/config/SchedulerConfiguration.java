package com.github.quartzcluster.config;

import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/** @author zouwei */
public class SchedulerConfiguration {

    @Bean(name = "scheduler", initMethod = "start", destroyMethod = "shutdown")
    public Scheduler scheduler(@Autowired SchedulerFactoryBean schedulerFactoryBean) {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        return scheduler;
    }
}
