JavaIDL: UserService
---------------------------------------------------------------------

This example shows how to create a Remote Facade pattern using the
CORBA middleware (Java IDL is shipped with the JDK).


How to compile the IDL file?
---------------------------------------------------------------------

$ idlj -fall -td src/generated/java src/main/resources/UserService.idl 


   
How to start the server process?
---------------------------------------------------------------------

$ java -cp ./target/classes org.se.lab.server.Main



How to run the client?
---------------------------------------------------------------------
Start the UserServiceTest class with a JUnit test-runner.


How to review the information stored in an IOR?
---------------------------------------------------------------------
We can use a tool which is part of the JacORG project:
http://www.jacorb.org/

$ dior -f UserService.ior 

INFO Initialising ORB with ID: 
------IOR components-----
TypeId	:	IDL:org/se/lab/UserService:1.0
TAG_INTERNET_IOP Profiles:
	Profile Id:		0
	IIOP Version:	1.2
	Host:			127.0.0.1
	Port:			39743
	Object key (URL):	%AF%AB%CB%00%00%00%00%20j%05a:%00%00%00%01%00%00%00%00%00%00%00%01%00%00%00%08RootPOA%00%00%00%00%08%00%00%00%01%00%00%00%00%14
	Object key (hex):	0xAF AB CB 00 00 00 00 20 6A 05 61 3A 00 00 00 01 00 00 00 00 00 00 00 01 00 00 00 08 52 6F 6F 74 50 4F 41 00 00 00 00 08 00 00 00 01 00 00 00 00 14 
	-- Found 2 Tagged Components--
	#0: TAG_CODE_SETS
		ForChar native code set Id: ISO8859_1
		Char Conversion Code Sets: UTF8, Unknown TCS: 0x10020
		ForWChar native code set Id: UTF16
		WChar Conversion Code Sets: UCS2
	#1: TAG_GROUP
		TAG_RMI_CUSTOM_MAX_STREAM_FORMAT: 2


