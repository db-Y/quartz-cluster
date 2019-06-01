package com.github.zw201913.quartzcluster.annotation;

import com.github.zw201913.quartzcluster.config.DynamicSchedulingConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DynamicSchedulingConfigurationSelector.class)
public @interface EnableQuartzCluster {
}
