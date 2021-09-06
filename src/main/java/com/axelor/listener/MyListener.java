package com.axelor.listener;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.axelor.module.MyModule;
import com.google.inject.Module;

public class MyListener extends GuiceResteasyBootstrapServletContextListener {

	@Override
	protected List<? extends Module> getModules(ServletContext arg0) {

		return Arrays.asList(new MyModule());
	}
}
