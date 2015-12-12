OWASP: JSON Sanitizer
-------------------------------------------------------------------------------
https://github.com/OWASP/json-sanitizer

Given JSON-like content, The JSON Sanitizer converts it to valid JSON.

Applied to JSON-like content from others, it will produce well-formed JSON that 
should satisfy any parser you use.

Applied to your output before you send, it will coerce minor mistakes in encoding 
and make it easier to embed your JSON in HTML and XML.


How to integrate the JSON Sanitizer into yor project?
-------------------------------------------------------------------------------
Just add the following dependency to your pom.xml

	<dependency>
		<groupId>com.mikesamuel</groupId>
		<artifactId>json-sanitizer</artifactId>
		<version>1.1</version>
	</dependency>
		