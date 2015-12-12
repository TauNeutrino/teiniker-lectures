How to access the REST service?
-------------------------------------------------------------------------------

URL: http://localhost:8080/REST-EJB-BeanValidation/v1/users

Testing bean validation: findById
-------------------------------------------------------------------------------

o) Valid id
GET http://localhost:8080 /REST-EJB-BeanValidation/v1/users/1

=> HTTP/1.1 200 OK

?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<user id="7">
	<username>bart</username>
	<password>Ls4jKY8G2ftFdy/bHTgIaRjID0Q=</password>
</user>


o) Invalid id
GET http://localhost:8080 /REST-EJB-BeanValidation/v1/users/0

=> HTTP/1.1 400 Bad Request
   [PARAMETER][findById.arg0][must be greater than or equal to 1][0]

   

Testing bean validation: insert 
-------------------------------------------------------------------------------
POST http://localhost:8080 /REST-EJB-BeanValidation/v1/users/

o) Valid input
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<user id="10">
		<username>maggie</username>
		<password>AZ2wv9X4WVHLRuRFLpZChYwAQVU=</password>
	</user>
	
	=> HTTP/1.1 204 No Content

o) Invalid id
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<user id="0">
		<username>maggie</username>
		<password>AZ2wv9X4WVHLRuRFLpZChYwAQVU=</password>
	</user>

	=> HTTP/1.1 400 Bad Request
	   [PARAMETER][insert.arg0.id][must be greater than or equal to 1][0]

o) Invalid username
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<user id="1">
		<username>mag</username>
		<password>AZ2wv9X4WVHLRuRFLpZChYwAQVU=</password>
	</user>
	
	=> HTTP/1.1 400 Bad Request
	[PARAMETER][insert.arg0.username][Invalid username format!][mag]


	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<user id="1">
		<username>mAggie</username>
		<password>AZ2wv9X4WVHLRuRFLpZChYwAQVU=</password>
	</user>
	
	=> HTTP/1.1 400 Bad Request
	   [PARAMETER][insert.arg0.username][Invalid username format!][mAggie]


o) Invalid password
	<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
		<user id="1">
		<username>maggie</username>
		<password>AZ2wv9X4</password>
	</user>
	
		=> HTTP/1.1 400 Bad Request
		   [PARAMETER][insert.arg0.password][Invalid password size!][AZ2wv9X4]

