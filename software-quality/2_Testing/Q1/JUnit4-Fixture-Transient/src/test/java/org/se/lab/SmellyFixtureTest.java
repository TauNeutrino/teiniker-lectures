package org.se.lab;

import org.junit.Assert;
import org.junit.Test;

public class SmellyFixtureTest
{
	@Test
	public void testBeanName()
	{
		// setup	
		MBean bean = new MBean("User");
        MProperty p1 = new MProperty("id", new MInteger());
        MString s = new MString();      
        MProperty p2 = new MProperty("username", s);
        p2.setVisible(true);        
        MProperty p3 = new MProperty("password", s);
        p3.setVisible(true);
        bean.addProperty(p1);
        bean.addProperty(p2);
        bean.addProperty(p3);

        // exercise
        String actual = bean.getBeanName();
        
        // verify
        Assert.assertEquals("User", actual);
        
        // teardown
	}
	
    @Test
    public void testBeanId()
    {
    	// setup
    	MBean bean = new MBean("User");
        MProperty p1 = new MProperty("id", new MInteger());
        MString s = new MString();      
        MProperty p2 = new MProperty("username", s);
        p2.setVisible(true);        
        MProperty p3 = new MProperty("password", s);
        p3.setVisible(true);
        bean.addProperty(p1);
        bean.addProperty(p2);
        bean.addProperty(p3);

        // verify
        Assert.assertEquals("id", bean.getProperties().get(0).getPropertyName());
        MType type = bean.getProperties().get(0).getType();
        Assert.assertTrue(type instanceof MInteger);
    }


    @Test
    public void testBeanUsername()
    {
    	// setup
    	MBean bean = new MBean("User");
        MProperty p1 = new MProperty("id", new MInteger());
        MString s = new MString();      
        MProperty p2 = new MProperty("username", s);
        p2.setVisible(true);        
        MProperty p3 = new MProperty("password", s);
        p3.setVisible(true);
        bean.addProperty(p1);
        bean.addProperty(p2);
        bean.addProperty(p3);

        // verify
        Assert.assertEquals("username", bean.getProperties().get(1).getPropertyName());
        MType type = bean.getProperties().get(1).getType();
        Assert.assertTrue(type instanceof MString);
    }

    @Test
    public void testBeanPassord()
    {
    	// setup
    	MBean bean = new MBean("User");
        MProperty p1 = new MProperty("id", new MInteger());
        MString s = new MString();      
        MProperty p2 = new MProperty("username", s);
        p2.setVisible(true);        
        MProperty p3 = new MProperty("password", s);
        p3.setVisible(true);
        bean.addProperty(p1);
        bean.addProperty(p2);
        bean.addProperty(p3);

        // verify
        Assert.assertEquals("password", bean.getProperties().get(2).getPropertyName());
        MType type = bean.getProperties().get(2).getType();
        Assert.assertTrue(type instanceof MString);
    }
}
