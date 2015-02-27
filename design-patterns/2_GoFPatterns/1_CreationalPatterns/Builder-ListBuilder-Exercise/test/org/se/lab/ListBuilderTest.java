package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ListBuilderTest
{
	private ListBuilder builder;
	
	@Before
	public void setup()
	{
		builder = new ListBuilder();

		// Director executes single steps to create a product
		builder.item("Hello").item("world").item("!");
	}
	

	@Test
	public void testToXml()
	{		
		String s = builder.toXml();
		
		String expected = 
				"<list>\n"	+
				"	<item>Hello</item>\n" +
				"	<item>world</item>\n" +
				"	<item>!</item>\n" +
				"</list>";
		
		Assert.assertEquals(expected, s);
	}
}
