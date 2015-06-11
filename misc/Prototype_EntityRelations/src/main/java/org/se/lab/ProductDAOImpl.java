package org.se.lab;

import javax.persistence.EntityManager;

public class ProductDAOImpl
	extends DAOImplTemplate<Product>
	implements ProductDAO
{

	public ProductDAOImpl(EntityManager em)
	{
		super(em);
	}
	
	@Override
	protected Class<Product> getEntityClass()
	{
		return Product.class;
	}

	
	public Product createProduct(String description, long price)
	{
		Product product = new Product(description, price);
		insert(product);
		return product;
	}
	
}
