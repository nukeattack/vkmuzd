package com.cryptobat.vkmuzd.jersey.config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JerseyConfigAuto extends JerseyConfig {
	public JerseyConfigAuto() {
		super(new ClassPathXmlApplicationContext("spring-conf.xml") );
	}
	
}
