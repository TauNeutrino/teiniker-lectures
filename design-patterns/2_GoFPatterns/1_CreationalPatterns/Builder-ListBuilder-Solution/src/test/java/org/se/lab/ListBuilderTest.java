package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class ListBuilderTest
{
	
	@Test
	public void testToXml()
	{		
		XmlListBuilder builder = new XmlListBuilder();
		// Director executes single steps to create a product
		builder.item("Hello").item("world").item("!");
		String s = builder.toXml();
		
		String expected = 
				"<list>\n"	+
				"	<item>Hello</item>\n" +
				"	<item>world</item>\n" +
				"	<item>!</item>\n" +
				"</list>";
		
		Assert.assertEquals(expected, s);
	}

	
	@Test
	public void testToText()
	{		
		TxtListBuilder builder = new TxtListBuilder();
		// Director executes single steps to create a product
		builder.item("Hello").item("world").item("!");
		String s = builder.toText();
		
		String expected = 
				"list:\n"	+
				"	- Hello\n" +
				"	- world\n" +
				"	- !\n";
		
		Assert.assertEquals(expected, s);
	}
}
