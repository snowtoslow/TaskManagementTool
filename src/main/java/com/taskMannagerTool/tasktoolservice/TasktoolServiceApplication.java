package com.taskMannagerTool.tasktoolservice;

import com.taskMannagerTool.tasktoolservice.configs.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class TasktoolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasktoolServiceApplication.class, args);
	}

}
