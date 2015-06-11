package org.se.lab;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product 
//	extends EntityBase
{
	/*
	 * Constructor
	 */
	public Product(int id, String description, long price)
	{
		setId(id);
		setDescription(description);
		setPrice(price);
	}
	public Product(String description, long price)
	{
		setDescription(description);
		setPrice(price);
	}
	
	protected Product()
	{
	}
	
	/*
	 * Property: id:int
	 */
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		if(id < 0)
			throw new IllegalArgumentException();
		this.id = id;
	}
	
	/*
	 * Property: description:String
	 */
	@Column(name="description")
	private String description;
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		if(description == null)
			throw new IllegalArgumentException();
		this.description = description;
	}
	
	
	/*
	 * Property: price:long
	 */
	@Column(name="price")
	private long price;
	public long getPrice()
	{
		return price;
	}
	public void setPrice(long price)
	{
		if(price < 0)
			throw new IllegalArgumentException();
		this.price = price;
	}
	
	
	/*
	 * Object methods
	 */
	@Override
	public String toString()
	{
		return getId() + ", " + getDescription() + ", " + getPrice();
	}	
}
