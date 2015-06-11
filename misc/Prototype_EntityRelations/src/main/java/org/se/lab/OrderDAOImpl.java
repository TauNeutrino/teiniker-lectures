package org.se.lab;

import java.util.List;

import javax.persistence.EntityManager;

public class OrderDAOImpl 
	extends DAOImplTemplate<Order>
	implements OrderDAO
{

	/*
	 * Constructor
	 */
	public OrderDAOImpl(EntityManager em)
	{
		super(em);
	}

	@Override 
	protected Class<Order> getEntityClass()
	{
		return Order.class;
	}
	
	/*
	 * Factory methods
	 */
	@Override
	public Order createOrder(String name, List<OrderLine> line)
	{
//		Order order = new Order(id, name, line);
		Order order = new Order(name, line);
//		order.setId(id);
//		order.setName(name);
//		for (OrderLine o : lines)
//		{
//			order.addOrderLine(o);
//		}
		insert(order);
		return order;
	}

}
