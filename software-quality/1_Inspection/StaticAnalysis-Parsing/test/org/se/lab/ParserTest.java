package org.se.lab;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.junit.Test;


public class ParserTest
{

	@Test
	public void testParser() throws RecognitionException, IOException
	{
		FileInputStream in = new FileInputStream(new File("source.h"));
		ANTLRInputStream input = new ANTLRInputStream(in);
		OperationLexer lexer = new OperationLexer(input);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		OperationParser parser = new OperationParser(tokens);
		parser.prog();
	}
}
