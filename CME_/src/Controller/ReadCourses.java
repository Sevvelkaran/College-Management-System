package Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Course;
import Model.Database;
import Model.Employee;
import Model.Operation;
import Model.Student;

public class ReadCourses implements Operation{

	@Override
	public void oper(Database database,Scanner scanner) {
		for(Course c:getAllCourses(Database database)) {
			c.print();
		}
		
	}
	public ArrayList<Course> getAllCourses(Database database){
		ArrayList<Course> courses= new ArrayList<>();
		ArrayList<Integer> classes= new ArrayList<>();
		ArrayList<Integer> profs= new ArrayList<>();
		ArrayList<Integer> departments= new ArrayList<>();
		String select="SELECT *FROM 'courses'";
		try {
			ResultSet rs=database.getStatement().executeQuery(select);
			while(rs.next()) {
				Course c=new Course();
				c.setID(rs.getInt(ID));
				c.setName(rs.getNString("Name"));
				classes.add(rs.getInt("Class"));
				c.setDescription(rs.getString("Description"));
				c.setLimit(rs.getInt("Lim"));
				profs.add(rs.getInt("Prof"));
				departments.add(rs.getInt("Department"));
				courses.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		for(int i=0;i<courses.size();i++) {
			courses.get(i).setClass(new Class(classes.get(i),database));
			courses.get(i).setProf(new Employee(Profs.get(i),database));
			courses.get(i).setDepartment(new Department(departments.get(i),database));
		}
	
		
		return courses;
		
	}

	
	

}
