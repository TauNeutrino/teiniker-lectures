package org.se.lab;


public class MProperty
{
	/*
	 * Constructor
	 */
	public MProperty(String propertyName, MType type)	
	{
		setPropertyName(propertyName);
		setType(type);
		setVisible(false);
	}
	
	
	/*
	 * Property: propertyName
	 */
	private String propertyName;
	public String getPropertyName()
	{
		return propertyName;
	}
	public void setPropertyName(String propertyName)
	{
		if(propertyName == null)
			throw new NullPointerException("propertyName");
		this.propertyName = propertyName;
	}
	
	
	/*
	 * Property: visibility
	 */
	private boolean visible;
	public boolean isVisible()
	{
		return visible;
	}
	public void setVisible(boolean visible)
	{
		this.visible = visible;
	}
	
	
	/*
	 * Association: ----[1]-> MType
	 */
	private MType type;
	public MType getType()
	{
		return type;
	}
	public void setType(MType type)
	{
		if(type == null)
			throw new NullPointerException("type");
		this.type = type;
	}
}
