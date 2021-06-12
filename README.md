# springboot-employees-app

## Requirements

For building and running the application you need:

- [JDK 1.8]
- [Maven 3]

This project uses m2 database in memory, so you don't have to configure any DB or run additional scripts.

## Run the application in local

There are many ways to run a Spring Boot application on your local machine, you can use one of the following:

- 1. Execute the `main` method in the `com.crud.employee.EmployeeApplication` class from your IDE, use the option 'Run as' --> 'Java Application' after use the option 'Run as' --> 'Maven install' to download the required dependencies defined in pom.xml.
- 2. Use the cmd console with the command 'java -jar target\employee-0.0.1-SNAPSHOT.jar', so you need to be located in your console, inside the dir where you unzipped the project.

Both of them are using an embedded TomcatWebServer

Once you get the message that the application started succesfully, you can import the postman project available in 'employee/Employees CRUD.postman_collection.json', you can fin there all the endpoints availablefor the CRUD operations in the rest application.

You can get a detail of the available methods with a basic Swagger implemented available in the following URL:

http://localhost:8080/swagger-ui.html#/employee-controller

Also you can use another tool to send the different requests:

- To create an employee (single employee)
	method: POST
	endpoint: localhost:8080/employees 
	Sample Body (mandatory):
		{
		  "name": "Michael Stone",
		  "office": "100A",
		  "email" : "michael.stone@oscorp.com",
		  "phone" : "415.331.3321",
		  "role" : "Teir 3 Support Engineer"
		}
		
- To create many employees (one or more employees)
	method: POST
	endpoint: localhost:8080/employees/list 
	Sample Body (mandatory):
		[
			{
				"name": "Michael Stone",
				"office": "321b",
				"email" : "michael.stone@oscorp.com",
				"phone" : "415.331.3321",
				"role" : "Teir 3 Support Engineer"
			},
			{
				"name": "Amber Johnson",
				"office": "332c",
				"email" : "amber.johnson@oscorp.com",
				"phone" : "415.337.4345",
				"role" : "Senior Project Manager"
			}
		]
		
- To retrieve all employees
	method: GET
	endpoint: localhost:8080/employees 

- To retrieve an employee by id
	method: GET
	endpoint: localhost:8080/employees/{employee_id}

- To update an employee
	method: PUT
	endpoint: localhost:8080/employees/{employee_id}
	Sample Body (mandatory):
		{
		  "name": "Orlando Suarez2",
		  "office": "305a",
		  "email" : "orlando.suarez@unosquare.com",
		  "phone" : "317.341.7695",
		  "role" : "Developer"
		}

- To delete an employee
	method: DELETE
	endpoint: localhost:8080/employees/{employee_id}