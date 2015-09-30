package org.se.lab;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart
	extends Entity
	implements XmlElement
{
	/*
	 * Constructor
	 */
	public ShoppingCart(int id)
	{
		super(id);
	}

	
	/*
	 * Property: articles
	 */
	private List<Article> articles = new ArrayList<Article>();
	public final List<Article> getArticles()
	{
		return articles;
	}
	public final void addArticle(final Article article)
	{
		if(article == null)
			throw new IllegalArgumentException("Parameter article is null!");
		articles.add(article);
	}
 	
	
	/*
	 * Operations
	 */
	
	@Override
	public String toString()
	{
		StringBuilder s = new StringBuilder();
		s.append("Cart: ").append(getId()).append("\n");
		for(Entity a : getArticles())
		{	
			s.append(a.toString()).append("\n");
		}		
		return s.toString();
	}
	
	
	@Override
	public String toXml()
	{
		StringBuilder s = new StringBuilder();
		s.append("<shoppingcard id=\"").append(getId()).append("\">\n");
		for(Article a : getArticles())
		{	
			s.append("\t").append(a.toXml()).append("\n");
		}		
		s.append("</shoppingcard>");
		return s.toString();
	}
}
