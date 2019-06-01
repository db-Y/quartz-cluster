package com.github.zw201913.quartzcluster.config;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/** @author zouwei */
public class DynamicSchedulingConfigurationSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
            ApplicationContextUtil.class.getName(),
            SchedulerConfiguration.class.getName()
        };
    }

}
