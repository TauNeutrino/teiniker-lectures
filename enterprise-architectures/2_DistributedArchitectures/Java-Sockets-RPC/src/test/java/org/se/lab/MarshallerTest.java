package org.se.lab;

import org.junit.Assert;
import org.junit.Test;
import org.se.lab.commons.Marshaller;
import org.se.lab.commons.RPCBooleanType;
import org.se.lab.commons.RPCRequest;
import org.se.lab.commons.RPCResponse;
import org.se.lab.commons.RPCStringType;
import org.se.lab.commons.RPCVoidType;

public class MarshallerTest
{	
	@Test
	public void testPRCOperation_addUser()
	{
		RPCRequest request = new RPCRequest("UserService:1.0","addUser", new RPCStringType("teini"), new RPCStringType("xxxxxxxxxx"));
		RPCResponse response = new RPCResponse(new RPCVoidType());
		
		Assert.assertEquals("request,UserService:1.0,addUser,teini,xxxxxxxxxx", Marshaller.marshal(request));
		Assert.assertEquals("response,ok,void", Marshaller.marshal(response));
	}


	@Test
	public void testPRCOperation_login()
	{
		RPCRequest request = new RPCRequest("UserService:1.0","login", new RPCStringType("homer"), new RPCStringType("xxxxxxxxxx"));		
		RPCResponse response = new RPCResponse(new RPCBooleanType(false)); 
		
		Assert.assertEquals("request,UserService:1.0,login,homer,xxxxxxxxxx", Marshaller.marshal(request));
		Assert.assertEquals("response,ok,false", Marshaller.marshal(response));
	}
}
