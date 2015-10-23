package org.se.lab;

import org.junit.Before;
import org.junit.Test;

public class OrderTest
{
	private Order order;
	
	@Before
	public void setup()
	{
		order = new Order(1, "Special order");
		order.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
		order.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));		
	}
	
	
	@Test
	public void testOrder()
	{
	    Order expected = new Order(1, "Special order");
	    expected.addOrderLine(new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880)));
	    expected.addOrderLine(new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820)));

	    CustomAssert.assertEquals(expected, order);
	}

	
	@Test // No longer needed - see testOrder
	public void testOrderLine1()
	{
		OrderLine actual = order.getOrderLines().get(0);		
		OrderLine expected = new OrderLine(2, 1, new Product(3, "Pizza Frutti di Mare", 880));
		
		CustomAssert.assertEquals(expected, actual);
	}

	
	@Test // No longer needed - see testOrder
	public void testOrderLine2()
	{
		OrderLine actual = order.getOrderLines().get(1);
		OrderLine expected = new OrderLine(4, 2, new Product(5, "Pizza Quattro Formaggi", 820));

		CustomAssert.assertEquals(expected, actual);
	}	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrder_IdIsNegative()
	{
		new Order(-1, "Special order");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrder_NameIsNull()
	{
		new Order(1, null);
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_IdIsNegative()
	{
		new OrderLine(-1, 1, new Product(3, "Pizza Frutti di Mare", 880));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_QuantityIsNegative()
	{
		new OrderLine(1, -1, new Product(3, "Pizza Frutti di Mare", 880));		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_ProductIsNull()
	{
		new OrderLine(1, 1, null);		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_IdIsNegative()
	{
		new Product(-1, "Pizza Frutti di Mare", 880);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_DescriptionIsNull()
	{
		new Product(1, null, 880);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_PriceIsNegative()
	{
		new Product(1, "Pizza Frutti di Mare", -880);
	}	
}
