package org.se.lab.commons;


public class Marshaller
{
	private Marshaller() {}
	
	
	/*
	 * Marshaller
	 */
	
	public static String marshal(RPCRequest request)
	{
		StringBuilder message = new StringBuilder();
		message.append("request,");
		message.append(request.getClassName()).append(","); 
		message.append(request.getOperationName()).append(",");
		
		for(int i=0; i< request.getParameters().size(); i++)
		{
			RPCType type = request.getParameters().get(i);
			message.append(marshal(type));
			
			if(i < request.getParameters().size()-1)
				message.append(",");
		}
		return message.toString();
	}
	
	
	public static String marshal(RPCType type)
	{
		if(type instanceof RPCStringType)
		{
			return marshal((RPCStringType)type);
		}
		else
		{
			throw new RPCCommunicationException("Invalid PRCType " + type);
		}
	}

		
	public static String marshal(RPCStringType type)
	{
		return type.getValue();
	}
	
	
	public static String marshal(RPCResponse response)
	{
		StringBuilder message = new StringBuilder();
		message.append("response,");
		if(response.getType() != null)
		{
			message.append("ok,");
			message.append(response.getType().toString());		
		}
		else
		{
			if(response.getException() instanceof RPCApplicationException)
			{
				message.append("application_error,");
			}
			else
			{
				message.append("communication_error,");
			}
			message.append(response.getException().toString());					
		}
		return message.toString();
	}
	
	
	/*	
	 * Demarshaller
	 */
	
	public static void unmershal(RPCResponse response, String responseMessage)
	{
		String[] tokens = responseMessage.split(",");
		
		// Check message for being a response
		if(!tokens[0].equals("response"))
		{
			response.setException(new RPCCommunicationException("Invalid response message: " + responseMessage));
		}
		else if(tokens[1].equals("ok"))
		{
			Marshaller.unmarshal(response.getType(), tokens[2]);
		}
		else if(tokens[1].equals("application_error"))
		{
			response.setException(new RPCApplicationException("Application error: " + responseMessage));
		}
		else if(tokens[1].equals("communication_error"))
		{
			response.setException(new RPCCommunicationException("Communication error: " + responseMessage));
		}
	}

	public static void unmarshal(RPCType type, String value)
	{
		if(type instanceof RPCStringType)
		{
			unmarshal((RPCStringType) type, value);
		}
		else if(type instanceof RPCBooleanType)
		{
			unmarshal((RPCBooleanType)type, value);
		}
		else if(type instanceof RPCVoidType)
		{
			unmarshal((RPCVoidType)type, value);
		}
	}
	
	public static void unmarshal(RPCStringType type, String value)
	{
		type.setValue(value);
	}
	
	public static void unmarshal(RPCBooleanType type, String value)
	{
		type.setValue(Boolean.parseBoolean(value));
	}

	public static void unmarshal(RPCVoidType type, String value)
	{
	}
}
