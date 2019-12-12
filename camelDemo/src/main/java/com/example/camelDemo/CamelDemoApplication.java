package com.example.camelDemo;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CamelDemoApplication {

	public static void main(String[] args) throws Exception {
		CamelContext context = new DefaultCamelContext();
		SpringApplication app = new SpringApplication(CamelDemoApplication.class);
		app.run();
		context.start();
        Thread.sleep(10000);
        context.stop();
	}

}
