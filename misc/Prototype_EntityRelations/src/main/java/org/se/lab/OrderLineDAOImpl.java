package org.se.lab;

import javax.persistence.EntityManager;

public class OrderLineDAOImpl
	extends DAOImplTemplate<OrderLine>
	implements OrderLineDAO
{

	public OrderLineDAOImpl(EntityManager em)
	{
		super(em);
	}

	@Override
	protected Class<OrderLine> getEntityClass()
	{
		return OrderLine.class;
	}
	
	@Override
	public OrderLine createOrderLine(int quantity, Product product)
	{
		OrderLine line = new OrderLine(quantity, product);
		insert(line);
		return line;
	}

}
