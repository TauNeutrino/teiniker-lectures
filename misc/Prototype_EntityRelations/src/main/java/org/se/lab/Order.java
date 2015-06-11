package org.se.lab;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order
//	extends EntityBase
{
	/*
	 * Constructor
	 */
	public Order(int id, String name)
	{
		setId(id);
		setName(name);
	}
	
	public Order(String name)
	{
		setName(name);
	}
	
	public Order(String name, List<OrderLine> orderLine)
	{
		setName(name);
		for (OrderLine o : orderLine)
		{
			addOrderLine(o);
		}
	}
	
	protected Order()
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
	 * Property: name:String
	 */
	@Column(name="name")
	private String name;
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		if(name == null)
			throw new IllegalArgumentException();
		this.name = name;
	}
	
	
	/*
	 * Association: ---[*]-> lines:Order
	 */
	@OneToMany(cascade={CascadeType.ALL})
	@JoinColumn(name="line_id", nullable=false)
	private List<OrderLine> lines = new ArrayList<OrderLine>();
	public void addOrderLine(OrderLine line)
	{
		if(line == null)
			throw new IllegalArgumentException();
		lines.add(line);
	}
	public List<OrderLine> getOrderLines()
	{
		return lines;
	}
	
	
	/*
	 * Object methods
	 */
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(getId()).append(", ").append(getName()).append("; ");
		for (OrderLine o : getOrderLines())
		{
			sb.append(o.getId()).append(", ").append(o.getQuantity()).append(", ").append(o.getProduct().getDescription()).append("; ");
		}
		return sb.toString();
	}

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
		Order other = (Order) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
