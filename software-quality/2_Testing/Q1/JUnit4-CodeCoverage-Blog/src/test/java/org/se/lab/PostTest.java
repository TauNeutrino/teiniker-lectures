package org.se.lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostTest
{
	private Post p;
	
	@Before
	public void setup()
	{
		p = new Post(1, "Eve hacked FB!");
	}

	@Test
	public void testConstructor()
	{
		Assert.assertEquals(1, p.getId());
		Assert.assertEquals("Eve hacked FB!", p.getText());
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testSetId_NegativeId()
	{
		p.setId(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetText_NullPointer()
	{
		p.setText(null);
	}
	
	@Test
	public void testToString()
	{
		Assert.assertEquals("1,Eve hacked FB!", p.toString());
	}
	
	@Test
	public void testHashCode()
	{
		Post q = new Post(1, "Eve hacked FB!");
		
		Assert.assertTrue(p.hashCode() == q.hashCode());
	}
	
	@Test
	public void testEquals_This()
	{
		Assert.assertTrue(p.equals(p));
	}
	
	@Test
	public void testEquals_Null()
	{
		Assert.assertFalse(p.equals(null));
	}
	
	@Test
	public void testEquals_WrongType()
	{
		Assert.assertFalse(p.equals(""));
	}
	
	@Test
	public void testEquals_WrongId()
	{
		Post q = new Post(2, "Eve hacked FB!");
		
		Assert.assertFalse(p.equals(q));
	}

	@Test
	public void testEquals()
	{
		Post q = new Post(1, "Eve hacked FB!");
		
		Assert.assertTrue(p.equals(q));
	}

}
