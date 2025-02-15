package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Model.Database;
import Model.Department;
import Model.Employee;
import Model.Operation;

public class ShowAllEmployees implements Operation {
	
	public void oper(Database database, Scanner scanner) {
		
		
		
		ArrayList<Employee> employees = new ArrayList<>();
		ArrayList<Integer> deptIDs = new ArrayList<>();
		
		try {
			
			String select = "SELECT * FROM `employees`;";
			ResultSet rs = database.getStatement().executeQuery(select);
			while(rs.next()) {
				Employee employee = new Employee();
				employee.setID(rs.getInt("ID"));
				employee.setFirstName(rs.getString("FirstName"));
				employee.setLastName(rs.getString("LastName"));
				employee.setEmail(rs.getString("Email"));
				employee.setPhoneNumber(rs.getString("PhoneNumber"));
				employee.setBirthDate(rs.getString("BirthDate"));
				employee.setSalary(rs.getDouble("Salary"));
				employee.setPassword(rs.getString("Password"));
				employees.add(employee);
				deptIDs.add(rs.getInt("Department"));
				
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		for(int i = 0; i<employees.size();i++) {
			employees.get(i).setDepartment(new Department(deptIDs.get(i), database));
		}
		for(Employee e: employees) {
			e.print();
		}
	}
	

}
