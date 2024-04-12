package ServiceLayer;

import Model.Employee;
import Reader.JsonReader;
import UtilsLayer.UtilsClass;

public class EmployeeService {

	public static Employee employee;

	public static String getPostRequestBody() throws Exception 
	{
		employee = JsonReader.readJsonNodeTestData("employeePayload.json", "createEmployee", Employee.class);
		
		return UtilsClass.convertPojoToJsonOfString(employee);
	}
	
	public static String getPutRequestBody() throws Exception 
	{
		employee = JsonReader.readJsonNodeTestData("employeePayload.json", "updateEmployee", Employee.class);
		
		return UtilsClass.convertPojoToJsonOfString(employee);
	}

}
