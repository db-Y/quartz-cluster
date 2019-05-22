package com.github.quartzcluster.core;

import com.github.quartzcluster.config.ApplicationContextUtil;
import com.github.quartzcluster.support.JobDefinition;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author zouwei
 */
@Slf4j
public class JobActuator {
    public static void invoke(JobDefinition jobDefinition) {
        String jobId = jobDefinition.getJobId();
        String springId = jobDefinition.getSpringId();
        String methodName = jobDefinition.getMethodName();
        String methodArgs = jobDefinition.getMethodArg();
        try {
            invoke(springId, methodName, methodArgs);
        } catch (NoSuchMethodException e) {
            log.error("无效的methodName:" + methodName, e);
        } catch (Exception e) {
            log.error("执行定时任务失败", e);
            log.error("id:{}，  springId:{}， methodName:{}", jobId, springId, methodName);
        }
    }

    /**
     * 执行定时任务
     *
     * @param springId
     * @param methodName
     * @param methodArgs
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    private static void invoke(String springId, String methodName, String methodArgs)
            throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Object object = ApplicationContextUtil.getBean(springId);
        if (Objects.isNull(object)) {
            log.error("无效的springId:" + springId);
            return;
        }
        Class<?> clazz = object.getClass();
        Method method;
        if (StringUtils.isBlank(methodArgs)) {
            method = clazz.getDeclaredMethod(methodName);
        } else {
            method = clazz.getDeclaredMethod(methodName, new Class[] {String.class});
        }
        method.setAccessible(true);
        if (StringUtils.isBlank(methodArgs)) {
            method.invoke(object);
        } else {
            method.invoke(object, methodArgs);
        }
    }
}
