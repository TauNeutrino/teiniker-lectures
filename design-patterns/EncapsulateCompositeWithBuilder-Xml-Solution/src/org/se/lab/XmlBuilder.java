package org.se.lab;

import java.util.Stack;

public class XmlBuilder 
    implements DocumentBuilder
{
    private Stack<XmlElement> stack = new Stack<XmlElement>();
     
    
    public void beginElement(String name)
    {
        XmlElement element = new XmlElement(name);        
        stack.push(element);
    }
    
    public void endElement()
    {        
        XmlElement element = stack.pop();
        if(stack.isEmpty())
        {
            stack.push(element);
        }
        else
        {
            XmlElement parent = stack.pop();
            parent.addElement(element); 
            stack.push(parent);
        }        
    }
    
    public void addText(String text)
    {
        XmlElement element = stack.pop();
        element.setText(text);
        stack.push(element);
    }
    
    public void addAttribute(String name, String value)
    {
        XmlAttribute attribute = new XmlAttribute(name,value);
        XmlElement element = stack.pop();
        element.addAttribute(attribute);
        stack.push(element);
    }
        
    public XmlDocument getDocument()
    {
    	XmlDocument document = new XmlDocument("1.0", "UTF-8");
    	document.setRoot(stack.firstElement());
        return document;
    }
}
