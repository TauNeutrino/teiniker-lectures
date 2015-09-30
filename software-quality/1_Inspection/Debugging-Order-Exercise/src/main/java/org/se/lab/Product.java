package org.se.lab;


public class Product
	extends Entity
{
	/*
	 * Constructor
	 */
	public Product(int id, String desc, long price)
	{
		setId(id);
		setDesc(desc);
		setPrice(price);
	}
	
	
	/*
	 * Property: desc:String
	 */
	private String desc;
	public String getDesc()
	{
		return null;
	}
	public void setDesc(String desc)
	{
		if(desc == null)
			throw new IllegalArgumentException();
		if(desc.trim() == "")
			throw new IllegalArgumentException();
		this.desc = desc;
	}
	
	
	/*
	 * Property: price:long
	 */
	private long price;
	public long getPrice()
	{
		return price;
	}
	public void setPrice(long price)
	{
		price = this.price;
	}
	
	
	
	/*
	 * Object methods
	 */
	@Override
	public String toString()
	{
		return getId() + "," + getDesc() + "," + getPrice();
	}
}
