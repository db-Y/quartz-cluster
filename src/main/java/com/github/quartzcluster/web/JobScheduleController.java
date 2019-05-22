package com.github.quartzcluster.web;

import com.github.quartzcluster.service.IScheduleService;
import com.github.quartzcluster.support.CronJobDefinition;
import com.github.quartzcluster.support.Key;
import com.github.quartzcluster.support.SimpleJobDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/** @author zouwei */

@RequestMapping("/job")
@RestController
public class JobScheduleController {

    @Autowired private IScheduleService scheduleService;

    /**
     * 添加cron任务
     *
     * @param cronJobDefinition
     * @return
     */
    @PostMapping("/addCronJob")
    public void add(@RequestPart("cronJobDefinition") CronJobDefinition cronJobDefinition) {
        scheduleService.schedule(cronJobDefinition);
    }

    /**
     * 添加简单任务
     *
     * @param simpleJobDefinition
     */
    @PostMapping("/addSimpleJob")
    public void add(@RequestPart("simpleJobDefinition") SimpleJobDefinition simpleJobDefinition) {
        scheduleService.schedule(simpleJobDefinition);
    }

    /**
     * 删除触发器
     *
     * @param key
     * @return
     */
    @DeleteMapping("/removeTrigger")
    public boolean removeTrigger(@RequestPart("key") Key key) {
        return scheduleService.removeTrigger(key);
    }

    /**
     * 暂停触发器
     *
     * @param key
     * @return
     */
    @PutMapping("/pauseTrigger")
    public void pauseTrigger(@RequestPart("key") Key key) {
        scheduleService.pauseTrigger(key);
    }

    /**
     * 恢复触发器
     *
     * @param key
     */
    @PutMapping("/resumeTrigger")
    public void resumeTrigger(@RequestPart("key") Key key) {
        scheduleService.resumeTrigger(key);
    }
}
