package org.se.lab;

import java.util.List;

public interface OrderDAO
	extends DAOTemplate<Order>
{
	public Order createOrder(String name, List<OrderLine> lines);
}
