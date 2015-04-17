package org.se.lab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.junit.Before;
import org.junit.Test;
import org.se.lab.metamodel.MPackage;

public class VelocityTest
{
	private MPackage pkg;
	private VelocityContext context;
	private static final String OUTPUT_FOLDER = "src/generated/java/org/se/lab/";
	
	@Before
	public void setup()
	{
		pkg = new PackageBuilder("org.se.lab")
		.iface("Stack").isPublic()
			.operation("push").asVoid().parameter("value").asInt()
			.operation("pop").asInt()
			.operation("top").asInt()
			.operation("isEmpty").asBoolean()
			.operation("isFull").asBoolean()			
		.toPackage();
		
		Velocity.init();
	    context = new VelocityContext();
        
        context.put("package", pkg);
        
        // TODO: Mehrere Interfaces möglich - hier oder im Template über die Liste iterieren
        context.put("iface", pkg.getInterfaces().get(0));
	}
	
	@Test
	public void testInterfaceVelocity()
	{
        Template template = Velocity.getTemplate("templates/InterfaceTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        // Write to file
        writeToFile(OUTPUT_FOLDER + "Stack.java", sw);
        
        //write to sysout
        System.out.println(sw);
	}

	
	@Test
	public void testAbstractDecoratorVelocity()
	{
		context.put("ifaceNameLower", pkg.getInterfaces().get(0).getName().substring(0, 1).toLowerCase() + 
			pkg.getInterfaces().get(0).getName().substring(1));
		
		Template template = Velocity.getTemplate("templates/AbstractDecoratorTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);

        // Write to file
        writeToFile(OUTPUT_FOLDER + "AbstractStackDecorator.java", sw);
        
        System.out.println(sw);
	}

	
	@Test
	public void testMonitorDecoratorGenerator()
	{
		context.put("ifaceNameLower", pkg.getInterfaces().get(0).getName().substring(0, 1).toLowerCase() + 
				pkg.getInterfaces().get(0).getName().substring(1));
		
		Template template = Velocity.getTemplate("templates/MonitorDecoratorTemplate.vm");
        StringWriter sw = new StringWriter();
        template.merge(context, sw);
        
        
        // Write to file
        writeToFile(OUTPUT_FOLDER + "StackMonitorDecorator.java", sw);
        
        System.out.println(sw);
	}
	
	public void writeToFile(String path, StringWriter data)
	{
		File file = new File(path);
		
		try
		{
			FileOutputStream fop = new FileOutputStream(file);
			fop.write(data.toString().getBytes());
			fop.close();
		}
		catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
