package com.github.quartzcluster.support;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.PersistJobDataAfterExecution;

/** @author zouwei */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DisallowConcurrentQuartzJob extends ConcurrentQuartzJob {}
