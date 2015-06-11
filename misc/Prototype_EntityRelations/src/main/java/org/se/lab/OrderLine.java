package org.se.lab;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_line")
public class OrderLine 
//	extends EntityBase
{
	/*
	 * Constructors
	 */
	
	public OrderLine(int id, int quantity)
	{
		setId(id);
		setQuantity(quantity);
	}
	
	public OrderLine(int quantity, Product product)
	{
		setQuantity(quantity);
		setProduct(product);
	}
	
	public OrderLine(int quantity)
	{
		setQuantity(quantity);
	}
	
	protected OrderLine()
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
	 * Property: quantity:int
	 */
	@Column(name="quantity")
	private int quantity;
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		if(quantity < 0)
			throw new IllegalArgumentException();
		this.quantity = quantity;
	}
	
		
	/*
	 * Association: ---[1]-> Product
	 */
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="product_id", nullable=false)
	private Product product;
	public Product getProduct()
	{
		return product;
	}
	public void setProduct(Product product)
	{
		if(product == null)
			throw new IllegalArgumentException();
		this.product = product;
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
		OrderLine other = (OrderLine) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	public String toString()
	{
		return getId() + ", " + getQuantity() + ", " + getProduct().getId();
	}

	
}
