package com.github.zw201913.quartzcluster.support;

import com.github.zw201913.quartzcluster.config.Const;
import com.github.zw201913.quartzcluster.core.JobActuator;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.springframework.scheduling.quartz.QuartzJobBean;

/** @author zouwei */
@PersistJobDataAfterExecution
public class ConcurrentQuartzJob extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        JobDefinition task = (JobDefinition) context.getMergedJobDataMap().get(Const.JOB_DATA_KEY);
        try {
            JobActuator.invoke(task);
        } catch (Exception e) {
            throw new JobExecutionException(e);
        }
    }
}
