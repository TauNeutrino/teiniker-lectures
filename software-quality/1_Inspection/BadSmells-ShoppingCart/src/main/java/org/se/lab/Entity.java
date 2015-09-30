package org.se.lab;

public abstract class Entity
{
	/*
	 * Constructor
	 */
	public Entity(int id)
	{
		setId(id);
	}

	
	/*
	 * Property: id:int
	 */
	private int id;
	public final void setId(final int id)
	{
		if (id < 0)
			throw new IllegalArgumentException("Invalid parameter id: " + id);
		this.id = id;
	}
	public final int getId()
	{
		return id;
	}

	
	/*
	 * Object methods
	 */
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (id != other.id)
			return false;
		return true;
	}
}