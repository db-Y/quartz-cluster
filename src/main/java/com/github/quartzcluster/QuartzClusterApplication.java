package com.github.quartzcluster;

import com.github.quartzcluster.annotation.EnableQuartzCluster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author zouwei
 */
@EnableQuartzCluster
//@EnableQuartzCluster("classpath:文件名")
//@EnableQuartzCluster("配置文件绝对路径")
@SpringBootApplication
public class QuartzClusterApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzClusterApplication.class, args);
    }
}
