package com.dadapro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 启动入口
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class Application  {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}
