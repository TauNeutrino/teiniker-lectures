package org.se.lab;

import java.util.Set;
import java.util.HashSet;
import javax.ws.rs.core.Application;

public class RESTApplication 
	extends Application
{
	private Set<Object> resources = new HashSet<Object>();
	private Set<Class<?>> empty = new HashSet<Class<?>>();

	public RESTApplication()
	{
		resources.add(new UserResourceImpl());
	}

	@Override
	public Set<Class<?>> getClasses()
	{
		return empty;
	}

	@Override
	public Set<Object> getSingletons()
	{
		return resources;
	}
}
