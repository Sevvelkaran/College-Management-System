package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;



import Model.Database;
import Model.Employee;
import Model.Operation;

public class CreateEmployee implements Operation {

    public void oper(Database database, Scanner scanner) {
        System.out.println("Enter First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Email:");
        String email = scanner.next();
        System.out.println("Enter Phone Number:");
        String phoneNumber = scanner.next();
        System.out.println("Enter Birth Date:");
        String birthDate = scanner.next();
        System.out.println("Enter Salary (double):");
        double salary = scanner.nextDouble();
        System.out.println("Enter Department ID (-1 to show all departments):");
        int deptID = scanner.nextInt();
        while (deptID < 0 )
{
        	new ShowAllDepartments().oper(database,scanner) ;
        	System.out.println("Enter Department ID (-1 to show all departments):");
        	deptID = scanner.nextInt();
}
        System.out.println("Enter Password:");
        String password = scanner.next();
        System.out.println("Confirm Password:");
        String confirmPassword = scanner.next(); 
        while(!confirmPassword.equals(password)) {
        	System.out.println("Enter Password:");
             password = scanner.next();
            System.out.println("Confirm Password:");
             confirmPassword = scanner.next(); 
        }
    
try {
        	ArrayList<Employee> employees =  new ShowAllEmployees().getAllEmployees(database);
        	int ID = 0;
        	if (employees.size()!= 0 ) {
        		ID = employees.get(employees.size()-1).getID()+1;
        	}
        	
        	 
//        	
//        
        	String insert = "INSERT INTO employees "
        		    + "(ID, FirstName, LastName, Email, PhoneNumber, BirthDate, Salary, Department, Password) "
        		    + "VALUES ("
        		    + ID + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNumber + "', '"
        		    + birthDate + "', " + salary + ", " + deptID + ", '" + password + "')";

        	database.getStatement().execute(insert);
        	System.out.println("Employee added successfully");
        			
        	
        }catch(SQLException e) {
        	e.printStackTrace();
        }  
    }

	@Override
	public void oper(Database database) {
		// TODO Auto-generated method stub
		
	}



	

	 
}