How to Start the Server (Remote Object)
-------------------------------------------------------------------------------

$ pwd
Java-Sockets-RPC

$ java -cp target/classes org.se.lab.server.Main
[Thu May 16 13:28:10 CEST 2013] RPC Server is running...

Run the JUnit test cases from Eclipse


How to Test the Server-Side?
-------------------------------------------------------------------------------

1. Testing the Remote Object
----------------------------
We run the "UserServiceTest" to test the server-side business logic.
There is no interprocess communication involved.


2. Testing the Invoker + Server Request Handler
-----------------------------------------------
The Invoker delegates a request to a particular Remote Object's method.
Here we use a simple "one object" static-dispatching.
 
The Server Request Handler receives a message from the network and delegates this
message toward the right Invoker.

Using the "InvokerTest", we create a on the wire message and send it to the
running server (don't forget to start the Main class). We simulate a client
request and receive the server's response on the request layer.


3. Testing the Marshaller
-------------------------
The Marshaller converts an object-oriented request or response into a message
format that can be used for network communication.
Note that the Marshaller is used on the client- and server-side.

"MarshallerTest" shows the usage of the simple serialization format.


How to Test the Client-Side?
-------------------------------------------------------------------------------

1. Testing the Requestor + Client Request Handler
-------------------------------------------------
The Requestor takes a generic request object and uses the Marshaller to convert
it into something the Client Request Handler can send to the server. 

Using the "RequestorTest" we can create dynamic request objects and send them
via Requestor and Client Request Handler to the server side.


2. Testing the Client Proxy
---------------------------
The Client Proxy provides a type-safe Interface for the Remote Object on the 
client-side.

The "ClientProxyTest" uses the UserService interface to invoke methods on the 
Remote Object.


How to Test a Remoting Error?
-------------------------------------------------------------------------------
"RemotingErrorTest" simulates an error condition. 

If the server is running a server-side IllegalArgumentException will be cause,
which is propagated to the client-side.

If the server is not running, a RPCCommunicationException will be thrown to
indicate a communication problem.

  