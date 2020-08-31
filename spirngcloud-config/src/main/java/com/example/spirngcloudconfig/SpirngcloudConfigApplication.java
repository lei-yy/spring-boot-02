package com.example.spirngcloudconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpirngcloudConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpirngcloudConfigApplication.class, args);
	}

}
