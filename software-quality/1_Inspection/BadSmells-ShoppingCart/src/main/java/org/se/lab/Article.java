package org.se.lab;

public abstract class Article 
	extends Entity
	implements XmlElement
{
	/*
	 * Constructor
	 */
	public Article(final int id, final String description, final long price)
	{
		super(id);
		setDescription(description);
		setPrice(price);
	}

	
	/*
	 * Property: description
	 */
	private String description;
	public final void setDescription(final String description)
	{
		if (description == null || description.trim().length() == 0)
			throw new IllegalArgumentException("Parameter description is null!");
		this.description = description;
	}
	public final String getDescription()
	{
		return description;
	}


	/*
	 * Property: price
	 */
	private long price;
	public final void setPrice(final long price)
	{
		if (price < 0)
			throw new IllegalArgumentException("Invalid parameter price: " + price);
		this.price = price;
	}
	public final long getPrice()
	{
		return price;
	}

	
	/*
	 * Operations
	 */

	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append(getId());
		s.append("\t").append(getDescription());
		s.append("\t").append(getPrice() / 100.0);
		return s.toString();
	}


	@Override
	public String toXml()
	{
		StringBuilder s = new StringBuilder();
		s.append(" id=\"").append(getId()).append("\"");
		s.append(" description=\"").append(getDescription()).append("\"");
		s.append(" price=\"").append(getPrice() / 100.0).append("\"");
		return s.toString();
	}
}
