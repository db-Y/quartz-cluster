package com.github.quartzcluster.service.impl;

import com.github.quartzcluster.service.IScheduleService;
import com.github.quartzcluster.support.CronJobDefinition;
import com.github.quartzcluster.support.Key;
import com.github.quartzcluster.support.SimpleJobDefinition;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @author zouwei */
@Service
public class ScheduleServiceImpl implements IScheduleService {

    @Autowired
    private Scheduler scheduler;

    @Override
    public void schedule(CronJobDefinition cronJobDefinition) {
        cronJobDefinition.scheduleJob(scheduler);
    }

    @Override
    public void schedule(SimpleJobDefinition simpleJobDefinition) {
        simpleJobDefinition.scheduleJob(scheduler);
    }

    /**
     * 暂停触发器
     * @param key
     */
    @Override
    public void pauseTrigger(Key key) {
        key.pauseTrigger(scheduler);
    }

    /**
     * 恢复触发器
     * @param key
     */
    @Override
    public void resumeTrigger(Key key) {
        key.resumeTrigger(scheduler);
    }

    /**
     * 移除触发器
     * @param key
     * @return
     */
    @Override
    public boolean removeTrigger(Key key) {
        return key.removeTrigger(scheduler);
    }
}
