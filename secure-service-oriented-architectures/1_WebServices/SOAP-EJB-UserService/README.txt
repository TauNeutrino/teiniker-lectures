How to access the WSDL definition?
-------------------------------------------------------------------------------

URL: http://localhost:8080/SOAP-EJB-UserService/UserService?wsdl


How to Generate Client-Side Stubs?
-------------------------------------------------------------------------------

$ pwd
SOAP-EJB-UserService

$ wsimport -verbose -Xnocompile -s src/gen/java -p org.se.lab.client http://localhost:8080/SOAP-EJB-UserService/UserService?wsdl

parsing WSDL...
Generating code...
Compiling code...

$ which wsimport 
/usr/java/jdk1.8.0_60/bin/wsimport

Note that we use the JDK's wsimport tool to generate the client-side classes 
because our JUnit test is running as a simple Java SE application.


How to Access the WSDL File?
-------------------------------------------------------------------------------
$ curl http://localhost:8080/SOAP-EJB-UserService/UserService?wsdl
  
GET /SOAP-EJB-UserService/UserService?wsdl HTTP/1.1

HTTP/1.1 200 OK
	<?xml version="1.0" ?><wsdl:definitions xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:wsdl="http://schemas.xmlsoap.org/wsdl/" xmlns:tns="http://service.lab.se.org/" xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/" xmlns:ns1="http://schemas.xmlsoap.org/soap/http" name="UserResourceEJBService" targetNamespace="http://service.lab.se.org/">
	<wsdl:types>
		<xs:schema xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:tns="http://service.lab.se.org/" elementFormDefault="unqualified" targetNamespace="http://service.lab.se.org/" version="1.0">
	
		  <xs:element name="delete" type="tns:delete"></xs:element>
		  <xs:element name="deleteResponse" type="tns:deleteResponse"></xs:element>
		  <xs:element name="findAll" type="tns:findAll"></xs:element>
		  <xs:element name="findAllResponse" type="tns:findAllResponse"></xs:element>
		  <xs:element name="findById" type="tns:findById"></xs:element>
		  <xs:element name="findByIdResponse" type="tns:findByIdResponse"></xs:element>
		  <xs:element name="insert" type="tns:insert"></xs:element>
		  <xs:element name="insertResponse" type="tns:insertResponse"></xs:element>
		  <xs:element name="update" type="tns:update"></xs:element>
		  <xs:element name="updateResponse" type="tns:updateResponse"></xs:element>
		  <xs:element name="user" type="tns:userDTO"></xs:element>
	
		  <xs:complexType name="insert">
		    <xs:sequence>
		      <xs:element minOccurs="0" name="arg0" type="tns:userDTO"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="userDTO">
		    <xs:sequence>
		      <xs:element minOccurs="0" name="username" type="xs:string"></xs:element>
		      <xs:element minOccurs="0" name="password" type="xs:string"></xs:element>
		    </xs:sequence>
		    <xs:attribute name="id" type="xs:int" use="required"></xs:attribute>
		  </xs:complexType>
	
		  <xs:complexType name="insertResponse">
		    <xs:sequence>
		      <xs:element minOccurs="0" name="return" type="tns:user"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="user">
		    <xs:sequence>
		      <xs:element name="id" type="xs:int"></xs:element>
		      <xs:element minOccurs="0" name="password" type="xs:string"></xs:element>
		      <xs:element minOccurs="0" name="username" type="xs:string"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="update">
		    <xs:sequence>
		      <xs:element name="arg0" type="xs:int"></xs:element>
		      <xs:element minOccurs="0" name="arg1" type="tns:userDTO"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="updateResponse">
		    <xs:sequence></xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="findById">
		    <xs:sequence>
		      <xs:element name="arg0" type="xs:int"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="findByIdResponse">
		    <xs:sequence>
		      <xs:element minOccurs="0" name="return" type="tns:userDTO"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="delete">
		    <xs:sequence>
		      <xs:element name="arg0" type="xs:int"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="deleteResponse">
		    <xs:sequence></xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="findAll">
		    <xs:sequence></xs:sequence>
		  </xs:complexType>
	
		  <xs:complexType name="findAllResponse">
		    <xs:sequence>
		      <xs:element maxOccurs="unbounded" minOccurs="0" name="return" type="tns:userDTO"></xs:element>
		    </xs:sequence>
		  </xs:complexType>
	
		</xs:schema>
	  </wsdl:types>
	  
	  
	  <wsdl:message name="findAllResponse">
	    <wsdl:part element="tns:findAllResponse" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="insert">
	    <wsdl:part element="tns:insert" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="update">
	    <wsdl:part element="tns:update" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="insertResponse">
	    <wsdl:part element="tns:insertResponse" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="updateResponse">
	    <wsdl:part element="tns:updateResponse" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="delete">
	    <wsdl:part element="tns:delete" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="findAll">
	    <wsdl:part element="tns:findAll" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="findById">
	    <wsdl:part element="tns:findById" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="findByIdResponse">
	    <wsdl:part element="tns:findByIdResponse" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  <wsdl:message name="deleteResponse">
	    <wsdl:part element="tns:deleteResponse" name="parameters">
	    </wsdl:part>
	  </wsdl:message>
	  
	  
	  <wsdl:portType name="UserService">
	  
	    <wsdl:operation name="insert">
	      <wsdl:input message="tns:insert" name="insert">
	    </wsdl:input>
	      <wsdl:output message="tns:insertResponse" name="insertResponse">
	    </wsdl:output>
	    </wsdl:operation>
	  
	    <wsdl:operation name="update">
	      <wsdl:input message="tns:update" name="update">
	    </wsdl:input>
	      <wsdl:output message="tns:updateResponse" name="updateResponse">
	    </wsdl:output>
	    </wsdl:operation>
	  
	    <wsdl:operation name="findById">
	      <wsdl:input message="tns:findById" name="findById">
	    </wsdl:input>
	      <wsdl:output message="tns:findByIdResponse" name="findByIdResponse">
	    </wsdl:output>
	  
	    </wsdl:operation>
	    <wsdl:operation name="delete">
	      <wsdl:input message="tns:delete" name="delete">
	    </wsdl:input>
	      <wsdl:output message="tns:deleteResponse" name="deleteResponse">
	    </wsdl:output>
	    </wsdl:operation>
	  
	    <wsdl:operation name="findAll">
	      <wsdl:input message="tns:findAll" name="findAll">
	    </wsdl:input>
	      <wsdl:output message="tns:findAllResponse" name="findAllResponse">
	    </wsdl:output>
	    </wsdl:operation>
	  
	  </wsdl:portType>
	  
	  
	  <wsdl:binding name="UserResourceEJBServiceSoapBinding" type="tns:UserService">
	    <soap:binding style="document" transport="http://schemas.xmlsoap.org/soap/http"></soap:binding>
	  
	    <wsdl:operation name="insert">
	      <soap:operation soapAction="" style="document"></soap:operation>
	      <wsdl:input name="insert">
	        <soap:body use="literal"></soap:body>
	      </wsdl:input>
	      <wsdl:output name="insertResponse">
	        <soap:body use="literal"></soap:body>
	      </wsdl:output>
	    </wsdl:operation>
	  
	    <wsdl:operation name="update">
	      <soap:operation soapAction="" style="document"></soap:operation>
	      <wsdl:input name="update">
	        <soap:body use="literal"></soap:body>
	      </wsdl:input>
	      <wsdl:output name="updateResponse">
	        <soap:body use="literal"></soap:body>
	      </wsdl:output>
	    </wsdl:operation>
	  
	    <wsdl:operation name="findById">
	      <soap:operation soapAction="" style="document"></soap:operation>
	      <wsdl:input name="findById">
	        <soap:body use="literal"></soap:body>
	      </wsdl:input>
	      <wsdl:output name="findByIdResponse">
	        <soap:body use="literal"></soap:body>
	      </wsdl:output>
	    </wsdl:operation>
	  
	    <wsdl:operation name="delete">
	      <soap:operation soapAction="" style="document"></soap:operation>
	      <wsdl:input name="delete">
	        <soap:body use="literal"></soap:body>
	      </wsdl:input>
	      <wsdl:output name="deleteResponse">
	        <soap:body use="literal"></soap:body>
	      </wsdl:output>
	    </wsdl:operation>
	  
	    <wsdl:operation name="findAll">
	      <soap:operation soapAction="" style="document"></soap:operation>
	      <wsdl:input name="findAll">
	        <soap:body use="literal"></soap:body>
	      </wsdl:input>
	      <wsdl:output name="findAllResponse">
	        <soap:body use="literal"></soap:body>
	      </wsdl:output>
	    </wsdl:operation>
	  
	  </wsdl:binding>
	  
	  
	  <wsdl:service name="UserResourceEJBService">
	    <wsdl:port binding="tns:UserResourceEJBServiceSoapBinding" name="UserServicePort">
	      <soap:address location="http://localhost:8080/SOAP-EJB-UserService/UserService"></soap:address>
	    </wsdl:port>
	  </wsdl:service>
	</wsdl:definitions>
  
  
How to Send a SOAP Message?
-------------------------------------------------------------------------------

POST /SOAP-EJB-UserService/UserService HTTP/1.1
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
	<S:Body>
		<ns2:findById xmlns:ns2="http://service.lab.se.org/">
			<arg0>1</arg0>
		</ns2:findById>
	</S:Body>
</S:Envelope>
  
  
HTTP/1.1 200 OK
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">
	<soap:Body>
		<ns2:findByIdResponse xmlns:ns2="http://service.lab.se.org/">
			<return id="1">
				<username>homer</username>
				<password>**********</password>
			</return>
		</ns2:findByIdResponse>
	</soap:Body>
</soap:Envelope>  

