package com.exa.de;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import io.sentry.Sentry;

@SpringBootApplication
@EnableDiscoveryClient
public class PassportDemoApplication {

	public static void main(String[] args) {
		Sentry.init(options -> {
			options.setDsn("http://9e21f4d388314e13b1a7ec51a64db71b@192.168.91.13:9000/2");
		});
		SpringApplication.run(PassportDemoApplication.class, args);
	}
}
