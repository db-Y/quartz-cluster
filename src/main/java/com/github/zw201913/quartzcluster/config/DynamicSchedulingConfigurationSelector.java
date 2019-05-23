package com.github.zw201913.quartzcluster.config;

import com.github.zw201913.quartzcluster.annotation.EnableQuartzCluster;
import com.google.common.collect.Maps;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/** @author zouwei */
public class DynamicSchedulingConfigurationSelector implements ImportSelector {

    public static final Map<String, Object> annotationAttrs = Maps.newConcurrentMap();

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        /** 获取指定的配置文件 */
        Map<String, Object> map =
                importingClassMetadata.getAnnotationAttributes(EnableQuartzCluster.class.getName());
        if (!CollectionUtils.isEmpty(map)) {
            map.forEach((key, value) -> annotationAttrs.put(key, value));
        }
        return new String[] {
            ApplicationContextUtil.class.getName(),
            DynamicSchedulingConfiguration.class.getName(),
            SchedulerConfiguration.class.getName()
        };
    }

    public static Object get(String key) {
        return annotationAttrs.get(key);
    }
}
