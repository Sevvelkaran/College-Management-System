package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Controller.CreateClass;
import Controller.CreateCourse;
import Controller.CreateDepartment;
import Controller.CreateEmployee;
import Controller.CreateStudent;
import Controller.DeleteClass;
import Controller.DeleteCourse;
import Controller.DeleteDepartment;
import Controller.DeleteEmployee;
import Controller.DeleteStudent;
import Controller.ReadClasses;
import Controller.ReadCourses;
import Controller.ReadDepartments;
import Controller.ReadEmployees;
import Controller.ReadStudents;
import Controller.UpdateClass;
import Controller.UpdateCourse;
import Controller.UpdateDepartment;
import Controller.UpdateEmployee;
import Controller.UpdateStudent;

public class Employee {
    private int ID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String birthDate;
    private double salary;
    private Department department;
    private String password;
     
    public Employee() {}
    
    public Employee(int ID,Database database) {
    	try {
    		
    		String select="SELECT ID, FirstName, LastName, Email, PhoneNumber, "
    			     +"BirthDate, Salary, Department, Password FROM employees WHERE ID="+getID()+";";

    	
			ResultSet rs=database.getStatement().executeQuery(select);
			rs.next();
			setID(rs.getInt("ID"));
			setFirstName(rs.getString("FirstName"));
			setLastName(rs.getString("LastName"));
			setEmail(rs.getString("Email"));
			setPhoneNumber(rs.getString("PhoneNumber"));
			setBirthDate(rs.getString("BirthDate"));
			setSalary(rs.getDouble("Salary"));
			setPassword(rs.getString("Password"));
			int deptID=rs.getInt("Department");
			setDepartment(new Department(deptID,database));
			
    }catch (SQLException e) {
    	e.printStackTrace();
    }
 }
    public int getID(){
    	return ID;
    }
    public void setID(int ID) {
    	this.ID=ID;
    }
    public String getFirstName(){
    	return firstName;
    }
    public void setFirstName(String firstName) {
    	this.firstName=firstName;
    }
    public String getLastName(){
    	return lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName=lastName;
    }
    public String getEmail(){
    	return email;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
    public String getPhoneNumber(){
    	return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
    	this.phoneNumber=phoneNumber;
    }    
    public String getBirthDate(){
    	return birthDate;
    }
    public void setBirthDate(String birthDate) {
    	this.birthDate=birthDate;
    }
    public double getSalary(){
    	return salary;
    }
    public void setSalary(double salary) {
    	this.salary=salary;
    }
    public Department getDepartment() {
    	return department;
    }
    public void setDepartment(Department department) {
    	this.department=department;
    }
    public String getPassword(){
    	return password;
    }
    public void setPassword(String password) {
    	this.password=password;
    }
    public void update(Database database) {
    	try {

    		String update = "UPDATE 'employees' SET 'ID'='"+getID()+"','FirstName'='"+getFirstName()+
    		"','LastName'='"+getLastName()+"','Email'='"+getEmail()+
    		"','PhoneNumber'='"+getPhoneNumber()+"','BirthDate'='"+getBirthDate()+
    		"','Salary'='"+getSalary()+"','Department'='"+getDepartment().getID()+
    		"','Password' ='"+getPassword()+" 'WHERE 'ID'="+getID()+";";
    		database.getStatement().execute(update); 
    		System.out.println("Employee updated successfully");		

    		} catch (SQLException e) {
              	e.printStackTrace();
    		}
    }
    public void print() {
    	System.out.println("ID:\t\t"+getID());
 
    	System.out.println("Name:\t\t"+getFirstName()+" "+getLastName());
    	System.out.println("Email:\t\t"+getEmail());
    	System.out.println("Phone Number:\t"+getPhoneNumber());
    	System.out.println("BirthDate:\t"+getBirthDate());
    	System.out.println("Salary:\t\t"+getSalary());
    	System.out.println("Department:\t"+getDepartment().getName());
    	System.out.println("______________________\n");
    }
    public void create(Database database) {
    	try {
    		String insert = "INSERT INTO employees "
        		    + "(ID, FirstName, LastName, Email, PhoneNumber, BirthDate, Salary, Department, Password) "
        		    + "VALUES ("
        		    + ID + ", '" + firstName + "', '" + lastName + "', '" + email + "', '" + phoneNumber + "', '"
        		    + birthDate + "', " + salary + ", " + department.getID() + ", '" + password + "')";

        	database.getStatement().execute(insert);
        	System.out.println("Employee added successfully");
        			
        	
        }catch(SQLException e) {
        	e.printStackTrace();
        } 
    	
    }
    private Operation[] managerOperations = new Operation[] {
        new CreateDepartment(),
        new ReadDepartments(),
        new UpdateDepartment(),
        new DeleteDepartment(),
        new CreateClass(),
        new ReadClasses(),
        new UpdateClass(),
        new DeleteClass(),
        new CreateCourse(),
        new ReadCourses(),
        new UpdateCourse(),
        new DeleteCourse(),
        new CreateEmployee(),
        new ReadEmployees(),
        new UpdateEmployee(),
        new DeleteEmployee(),
        new CreateStudent(),
        new ReadStudents(),
        new UpdateStudent(),
        new DeleteStudent()

        };
    

    public void showList (Database database, Scanner scanner,int ID) {
    	if (department.getName().equals("Management")) {
    		System.out.println("Welcome to University Management System");
    	    System.out.println("01. Add new Department");
    	    System.out.println("02. Show all Departments");
    	    System.out.println("03. Edit Department");
    	    System.out.println("04. Delete Department");
    	    System.out.println("05. Add New Class");
    	    System.out.println("06. Edit Class");
    	    System.out.println("07. Delete Class");
    	    System.out.println("08. Add new Course");
    	    System.out.println("09. Show all Courses");
    	    System.out.println("10. Edit Course");
    	    System.out.println("11. Delete Course");
    	    System.out.println("12. Add new Employee");
    	    System.out.println("13. Show all Employees");
    	    System.out.println("14. Edit Employee");
    	    System.out.println("15. Delete Employee");
    	    System.out.println("16. Add new Student");
    	    System.out.println("17. Show all Students");
    	    System.out.println("18. Edit Student");
    	    System.out.println("19. Delete Student");
    	    
    	    int selected=scanner.nextInt();
    	    managerOperations[selected-1].oper(database,scanner);
    	    showList(database,scanner, selected);//changed code
    	}
        else {
    		
    	}
    	
    }
}



