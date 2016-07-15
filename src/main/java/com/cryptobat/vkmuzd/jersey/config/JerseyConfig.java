package com.cryptobat.vkmuzd.jersey.config;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.Container;
import org.glassfish.jersey.server.spi.ContainerLifecycleListener;
import org.jvnet.hk2.spring.bridge.api.SpringBridge;
import org.jvnet.hk2.spring.bridge.api.SpringIntoHK2Bridge;
import org.springframework.context.ApplicationContext;

public class JerseyConfig extends ResourceConfig{
	private static ApplicationContext springContext;
	private ServiceLocator serviceLocator;
	
	public JerseyConfig(ApplicationContext springContext){
		JerseyConfig.springContext = springContext;
		register(new ContainerLifecycleListener() {
			@Override
			public void onStartup(Container container) {
				setServiceLocator(container.getApplicationHandler().getServiceLocator());
			}
			
			@Override
			public void onShutdown(Container container) {
				
			}
			
			@Override
			public void onReload(Container container) {
				
			}
		});		
		packages("com.cryptobat.vkmuzd.services");
	}

	public ServiceLocator getServiceLocator() {
		return serviceLocator;
	}

	public void setServiceLocator(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator;
		SpringBridge.getSpringBridge().initializeSpringBridge(serviceLocator);
		SpringIntoHK2Bridge springBridge = serviceLocator.getService(SpringIntoHK2Bridge.class);
		springBridge.bridgeSpringBeanFactory(springContext);		
	}
}
