package org.se.lab;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.se.lab.Entity;
import org.se.lab.Product;

public class ProductTest
{
	/*
	 * Association: ---[1]-> p:Product
	 */
	private Product p;

	@Before
	public void setup()
	{
		p = new Product(3,"Java Programming", 3550);

		Entity.setNextId(1);
	}

	@Test
	public void testProduct()
	{
		out.println("@Test testProduct");
		String s = p.toString();
		assertEquals("3,Java Programming,35.5", s);
	}

	@Test(expected = NullPointerException.class)
	public void testTitleNull()
	{
		new Product(3,null, 3550);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPriceNegative()
	{
		new Product(3, "Java Programming", -3550);
	}


	@Test
	public void testNextId()
	{
		Product p1 = new Product("Java Programming", 3550);
		assertEquals(1, p1.getId());

		Product p2 = new Product("Programming C", 1790);
		assertEquals(2, p2.getId());
	}

	@Test
	public void testDefaultConstructor()
	{
		Product p = new Product();
		p.setId(7).setTitle("").setPrice(1210);
	}


	@Test
	public void testToXml()
	{
		final String EXPECTED = 
			"<product id=\"3\" title=\"Java Programming\" price=\"35.5\"/>";
		String xml = p.toXml();
		assertEquals(EXPECTED, xml);
		System.out.println(xml);
		
	}
}
