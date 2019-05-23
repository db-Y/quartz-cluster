package com.github.zw201913.quartzcluster.config;

import com.github.zw201913.quartzcluster.annotation.EnableQuartzCluster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.sql.DataSource;
import java.util.Objects;

/** @author zouwei */
public class DynamicSchedulingConfiguration {

    /** 获取spring中的数据源 */
    @Autowired private DataSource dataSource;

    @Bean(name = "schedulerFactoryBean", destroyMethod = "destroy")
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        // 设置数据源
        factory.setDataSource(dataSource);
        // 设置配置文件
        factory.setConfigLocation(propertiesResource());
        // 启动是否自动执行
        factory.setAutoStartup(true);
        // 是否覆盖已有的job
        factory.setOverwriteExistingJobs(true);
        // 项目启动5秒后开始执行定时任务
        factory.setStartupDelay(5);
        return factory;
    }

    /**
     * 获取配置文件
     *
     * @return
     */
    private Resource propertiesResource() {
        String value = (String) DynamicSchedulingConfigurationSelector.get("value");
        if (Objects.isNull(value)) {
            return new ClassPathResource(EnableQuartzCluster.DEFAULT_PROPERTIES);
        }
        if (value.indexOf(EnableQuartzCluster.CLASSPATH_PREFIX) == 0) {
            return new ClassPathResource(value.replace(EnableQuartzCluster.CLASSPATH_PREFIX, ""));
        }
        return new FileSystemResource(value);
    }
}
