package org.se.lab;

public class Book
	extends Article
{
	public Book(final int id, final String description, final String author, 
			final long price)
	{
		super(id, description,price);
		setAuthor(author);
	}
	
	
	/*
	 * Property: author
	 */
	private String author; // Temporary Field
	public final void setAuthor(final String author)
	{
		if (author == null)
			throw new IllegalArgumentException("Parameter author is null!");
		this.author = author;
	}
	public final String getAuthor()
	{
		return author;
	}

	
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("BOOK:\t").append(getId());
		s.append("\t").append(getDescription());
		s.append("\t").append(getAuthor());
		s.append("\t").append(getPrice() / 100.0);
		return s.toString();
	}

	@Override
	public String toXml()
	{
		return "<book" + super.toXml() + " author=\"" + author + "\"/>";
	}
}
