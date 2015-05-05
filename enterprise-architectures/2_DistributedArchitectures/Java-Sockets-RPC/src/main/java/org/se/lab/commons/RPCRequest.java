package org.se.lab.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RPCRequest
{
	/*
	 * Constructor
	 */
	public RPCRequest(String className, String operationName, RPCType... parameters)
	{
		setOperationName(operationName);
		setClassName(className);
		setParameters(Arrays.asList(parameters));
	}
	
	
	/*
	 * Property: operationName:String
	 */
	private String operationName;
	public String getOperationName()
	{
		return operationName;
	}
	public void setOperationName(String operationName)
	{
		this.operationName = operationName;
	}
	
	
	/*
	 * Property: className:String 
	 */
	private String className;
	public String getClassName()
	{
		return className;
	}
	public void setClassName(String className)
	{
		this.className = className;
	}


	/*
	 * Association: parameters:RPCType[*]
	 */
	private List<RPCType> parameters = new ArrayList<RPCType>();
	public List<RPCType> getParameters()
	{
		return parameters;
	}
	public void setParameters(List<RPCType> parameters)
	{
		this.parameters = parameters;
	} 	
}
