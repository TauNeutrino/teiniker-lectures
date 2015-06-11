package org.se.lab;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OrderDAOTest
{
	private static final JdbcTestHelper JDBC_HELPER = new JdbcTestHelper();
	private final static JpaTestHelper JPA_HELPER = new JpaTestHelper();

	private EntityManager em = JPA_HELPER.getEntityManager("test");
    private Order order;
	
	@BeforeClass
	public static void init()
	{
		JDBC_HELPER.executeSqlScript("sql/CreateOrderOrderLineProductTables.sql");
	}
	
	@AfterClass
	public static void destroy()
	{
		JDBC_HELPER.executeSqlScript("sql/DropOrderOrderLineProductTables.sql");		
	}
	
	
	@Before
    public void setUp()
    {
		JPA_HELPER.txBegin();
		
		Product frutti = new Product(1, "Pizza Frutti di Mare", 9);
		Product margharita = new Product(2, "Pizza Margharita", 8);
//		Product frutti = new Product("Pizza Frutti di Mare", 9);
//		Product margharita = new Product("Pizza Margharita", 8);
		
		OrderLine line1 = new OrderLine(1, 1);
		OrderLine line2 = new OrderLine(2, 3);
//		OrderLine line1 = new OrderLine(1);
//		OrderLine line2 = new OrderLine(3);
		line1.setProduct(frutti);
		line2.setProduct(margharita);
		
		order = new Order(1, "Special Order No. 1");
//		Order order = new Order("Special Order No. 1");
		order.addOrderLine(line1);
		order.addOrderLine(line2);
		
		em.persist(order);
    }   

    @After
    public void tearDown()
    {
    	JPA_HELPER.txRollback();
    }
    
    
    @Test
	public void testOrder()
	{
		Assert.assertEquals(1, order.getId());
		Assert.assertEquals("Special Order No. 1", order.getName());
		Assert.assertEquals(2, order.getOrderLines().size());
	}

    
    @Test
	public void testOrderLine1()
	{
    	// line 1: 1x Frutti di Mare, price 9
		OrderLine line1 = order.getOrderLines().get(0);
		
		Assert.assertEquals(1, line1.getId());
		Assert.assertEquals(1, line1.getQuantity());
		Assert.assertNotNull(line1.getProduct());
		
		Product p = line1.getProduct();
		Assert.assertEquals(1, p.getId());
		Assert.assertEquals("Pizza Frutti di Mare", p.getDescription());
		Assert.assertEquals(9, p.getPrice());
	}
    
    @Test
	public void testOrderLine2()
	{
    	// line 1: 1x Frutti di Mare, price 9
		OrderLine line2 = order.getOrderLines().get(1);

		Assert.assertEquals(2, line2.getId());
		Assert.assertEquals(3, line2.getQuantity());
		Assert.assertNotNull(line2.getProduct());
		
		Product p = line2.getProduct();
		Assert.assertEquals(2, p.getId());
		Assert.assertEquals("Pizza Margharita", p.getDescription());
		Assert.assertEquals(8, p.getPrice());

	}	
    
//    @Test(expected = IllegalArgumentException.class)
//	public void testOrder_IdIsNegative()
//	{
//		new Order(-1, "Special order");
//	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrder_NameIsNull()
	{
		new Order(null);
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_QuantityIsNegative()
	{
		new OrderLine(-1, new Product("Pizza Frutti di Mare", 880));		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testOrderLine_ProductIsNull()
	{
		new OrderLine(1, null);		
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_DescriptionIsNull()
	{
		new Product(null, 880);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testProduct_PriceIsNegative()
	{
		new Product("Pizza Frutti di Mare", -880);
	}	
}
