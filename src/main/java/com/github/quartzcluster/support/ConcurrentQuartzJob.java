package com.github.quartzcluster.support;

import com.github.quartzcluster.config.Const;
import com.github.quartzcluster.core.JobActuator;
import org.quartz.JobExecutionContext;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/** @author zouwei */
@PersistJobDataAfterExecution
public class ConcurrentQuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) {
        JobDefinition task = (JobDefinition) context.getMergedJobDataMap().get(Const.JOB_DATA_KEY);
        JobActuator.invoke(task);
    }
}
