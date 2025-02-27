package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

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
}



