package org.se.lab;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.apache.log4j.Logger;

public class ClientSideHandler 
    implements SOAPHandler<SOAPMessageContext>
{
    private final Logger LOG = Logger.getLogger(ClientSideHandler.class);
    
    @Override
    public boolean handleMessage(SOAPMessageContext context)
    {
        LOG.info("handleMessage()");
        
        StringBuilder msg = new StringBuilder();
        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if(isRequest)
            msg.append("SOAP Response:");
        else
            msg.append("SOAP Request:");

        try
        {
            SOAPMessage soapMsg = context.getMessage();
            SOAPEnvelope soapEnv = soapMsg.getSOAPPart().getEnvelope();
            SOAPHeader soapHeader = soapEnv.getHeader();

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            soapMsg.writeTo(out);
            msg.append(out); 
            
            
//            //add a soap header, name as "mac address"
//            QName qname = new QName("http://ws.mkyong.com/", "macAddress");
//            SOAPHeaderElement soapHeaderElement = soapHeader.addHeaderElement(qname);
//
//            soapHeaderElement.setActor(SOAPConstants.URI_SOAP_ACTOR_NEXT);
//            soapHeaderElement.addTextNode(mac);
//            soapMsg.saveChanges();

        }
        catch (SOAPException e)
        {
            System.err.println(e);
        }
        catch (IOException e)
        {
            System.err.println(e);
        }
        
        LOG.info(msg.toString());
        return true; // forward message
    }

    @Override
    public boolean handleFault(SOAPMessageContext context)
    {
        LOG.info("handleFault()");
        return true;
    }

    @Override
    public void close(MessageContext context)
    {
        LOG.info("close()");
    }

    @Override
    public Set<QName> getHeaders()
    {
        LOG.info("getHeaders()");
        return null;
    }
}
