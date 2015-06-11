package org.se.lab;

public interface OrderLineDAO 
	extends DAOTemplate<OrderLine>
{
	public OrderLine createOrderLine(int quantity, Product product);
}
