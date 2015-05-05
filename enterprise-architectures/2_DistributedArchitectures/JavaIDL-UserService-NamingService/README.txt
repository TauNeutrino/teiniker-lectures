CORBA Naming Service
--------------------------------------------------------------------------
The Naming Service allows object implementations to be identified by name 
and is thus a fundamental service for distributed object systems.

The Naming Service provides a mapping between a name and an object
reference. Storing such a mapping in the Naming Service is known as
binding an object to a name, and removing this entry is called unbinding 
the name.
Obtaining an object reference that is bound to a name is known as
resolving the name.

Names can be hierarchically structured by using contexts.
Contexts are similar to directories in file systems, and they can contain
name bindings as well as subcontexts. 


How to compile the IDL file?
---------------------------------------------------------------------

$ idlj  -fall -td src/generated/java src/main/resources/UserService.idl 


How to start the Naming Server?
---------------------------------------------------------------------
$ su
root66

# orbd -port 5050

Note that on Linux systems you should run the Naming Server as root to get
all the permissions.


How to start the server 
---------------------------------------------------------------------

$ java -cp ./target/classes org.se.lab.server.Main -ORBInitRef NameService=corbaloc:iiop:1.2@localhost:5050/NameService
 
 
How to start the client
---------------------------------------------------------------------

$ java -cp ./target/classes org.se.lab.client.Main -ORBInitRef NameService=corbaloc:iiop:1.2@localhost:5050/NameService


How to browse the NameService content?
---------------------------------------------------------------------
By using the JacORB tools we can explore the content of the Naming 
Service. (Note that you should have a valid JacORB installation to 
do that: http://www.jacorb.org/)

$ nmg -ORBInitRef NameService=corbaloc:iiop:1.2@localhost:5050/NameService 

