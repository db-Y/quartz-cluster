package com.github.zw201913.quartzcluster.web;

import com.github.zw201913.quartzcluster.service.IScheduleService;
import com.github.zw201913.quartzcluster.support.CronJobDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class ScheduleController {
    @Autowired
    private IScheduleService scheduleService;

    /**
     * 添加cron定时任务
     *
     * @param cronJobDefinition
     */
    @PostMapping("/addCronJob")
    public void schedule(@RequestPart("cronJobDefinition") CronJobDefinition cronJobDefinition) {
        scheduleService.schedule(cronJobDefinition);
    }
}
