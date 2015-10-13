package org.se.lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MBean
{
	/*
	 * Constructor
	 */
	public MBean(String beanName)
	{
		setBeanName(beanName);
	}
	
	
	/*
	 * Property: beanName
	 */
	private String beanName;
	public String getBeanName()
	{
		return beanName;
	}
	public void setBeanName(String beanName)
	{
		if(beanName == null)
			throw new NullPointerException("beanName");
		this.beanName = beanName;
	}
	
	
	/*
	 * Association: ----[*]-> MProperty
	 */
	private List<MProperty> properties = new ArrayList<MProperty>();
	public List<MProperty> getProperties()
	{
		return Collections.unmodifiableList(properties);
	}
	public void addProperty(MProperty property)
	{
		if(property == null)
			throw new NullPointerException("property");
		properties.add(property);
	}
}