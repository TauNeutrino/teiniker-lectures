package org.se.lab.service;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;

public class RESTApplication 
	extends Application
{
	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public RESTApplication()
	{
		classes.add(UserResourceEJB.class);
	}

	@Override
	public Set<Class<?>> getClasses()
	{
		return classes;
	}

	@Override
	public Set<Object> getSingletons()
	{
		return singletons;
	}
}
