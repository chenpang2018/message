package com.ecpss.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class MessageSyswarApplication extends SpringBootServletInitializer{

	public MessageSyswarApplication() {
		super();
		super.setRegisterErrorPageFilter(Boolean.FALSE);

	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(MessageSyswarApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MessageSyswarApplication.class, args);
	}
}
