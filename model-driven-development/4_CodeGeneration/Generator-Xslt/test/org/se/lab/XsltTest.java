package org.se.lab;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Test;


public class XsltTest 
{

	@Test
	public void testCpdReport() throws TransformerException, IOException
	{
		process("xml/cpd-report.xml", 
				"xml/cpdhtml.xslt", 
				"cpd-retort.html");		
	}
	
	@Test
	public void testJavaNcssReport() throws TransformerException, IOException
	{
		process("xml/javancss-report.xml", 
				"xml/javancss2html.xsl", 
				"javancss-retort.html");		
	}
	
	@Test
	public void testJavaNcssClasses() throws TransformerException, IOException
	{
		process("xml/javancss-report.xml", 
				"xml/javancss-classes.xslt", 
				"javancss-classes.xml");		
	}
	
	
	protected void process(final String xml, final String xslt, final String out) 
		throws IOException, TransformerException
	{
		Source xmlSource = new StreamSource(new File(xml));
		Source xsltSource = new StreamSource(new File(xslt));
		
		Result result = new StreamResult(new FileWriter(new File(out)));
		
		// create an instance of TransformerFactory
		TransformerFactory transFact = TransformerFactory.newInstance();
		Transformer trans = transFact.newTransformer(xsltSource);
		trans.transform(xmlSource, result);		
	}
}
