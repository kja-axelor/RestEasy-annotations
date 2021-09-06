package com.axelor.module;

import com.axelor.resource.Resource;
import com.google.inject.AbstractModule;

public class MyModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(Resource.class);
	}
}
