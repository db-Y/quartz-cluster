package com.github.quartzcluster.support;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerKey;

/** @author zouwei */
@Data
public class Key {

    protected static final String DEFAULT_GROUP = "default_group";

    /** 任务名称 */
    private String name;
    /** 任务分组 */
    private String group;

    /**
     * 暂停触发器
     *
     * @param scheduler
     */
    public void pauseTrigger(Scheduler scheduler) {
        TriggerKey triggerKey = triggerKey();
        try {
            scheduler.pauseTrigger(triggerKey);
        } catch (SchedulerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 恢复触发器
     *
     * @param scheduler
     */
    public void resumeTrigger(Scheduler scheduler) {
        TriggerKey triggerKey = triggerKey();
        try {
            scheduler.resumeTrigger(triggerKey);
        } catch (SchedulerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 删除触发器
     *
     * @param scheduler
     */
    public boolean removeTrigger(Scheduler scheduler) {
        TriggerKey triggerKey = triggerKey();
        try {
            scheduler.pauseTrigger(triggerKey);
            return scheduler.unscheduleJob(triggerKey);
        } catch (SchedulerException e) {
            throw new IllegalArgumentException(e);
        }
    }

    protected TriggerKey triggerKey() {
        return new TriggerKey(getName(), getGroup());
    }

    /**
     * 获取group
     *
     * @return
     */
    public String getGroup() {
        return StringUtils.isBlank(group) ? DEFAULT_GROUP : group;
    }
}
