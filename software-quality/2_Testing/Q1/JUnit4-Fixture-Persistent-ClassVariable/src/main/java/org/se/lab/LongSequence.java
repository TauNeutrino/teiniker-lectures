package org.se.lab;

public final class LongSequence
{
	private final static long INITIAL_SEQUENCE_NUMBER = 1;
	
	/*
	 * Constructor
	 */
	private LongSequence() {}
	
	
	/*
	 * Property: sequenceNumber:long
	 */
	private static long sequenceNumber = INITIAL_SEQUENCE_NUMBER; 
	
	public synchronized static long getNextSequenceNumber()
	{
		return sequenceNumber++;
	}
	
	public synchronized static void setSequenceNumber(long id)
	{
		LongSequence.sequenceNumber = id;
	}	
	
	public synchronized static void resetSequenceNumber()
	{
		LongSequence.sequenceNumber = INITIAL_SEQUENCE_NUMBER;
	}
}
