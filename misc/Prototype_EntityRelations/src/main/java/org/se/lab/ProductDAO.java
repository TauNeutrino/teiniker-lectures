package org.se.lab;

public interface ProductDAO
extends DAOTemplate<Product>
{
	public Product createProduct(String description, long price);
}
