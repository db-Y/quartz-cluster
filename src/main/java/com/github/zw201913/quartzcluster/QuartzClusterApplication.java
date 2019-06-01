package com.github.zw201913.quartzcluster;

import com.github.zw201913.quartzcluster.annotation.EnableQuartzCluster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableQuartzCluster
@SpringBootApplication
public class QuartzClusterApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuartzClusterApplication.class, args);
	}

}
