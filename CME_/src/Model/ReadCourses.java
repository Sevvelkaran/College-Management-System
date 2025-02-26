package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Controller.ArrayList;

public class ReadCourses implements Operation{

	
	@Override
	public void oper(Database database,Scanner scanner) {
		for(Course c:getAllCourses(database)) {
			System.out.println(c.print());
		
		
	}
	public ArrayList<Model.Course> getAllCourses(Database database){
		ArrayList<Course> courses=new ArrayList<>();
	}
		ArrayList<Integer> classes=new ArrayList<>();
		java.util.ArrayList<Integer> profs=new ArrayList<>();
	}
	    String select="SELECT *FROM COURSES';";
	    try {
	    	ResultSet rs=database.getStatement().executeQuery(select);
	    	while(rs.next()) {
	    	    Course c=new Course();
	        	c.setID(rs.getInt("ID"));
	        	c.setName(rs.getString("Name"));
	        	classes.add(rs.getInt("Class"));
	        	c.setDescription(rs.getString("Description"));
	        	c.setLimit(rs.getInt("Limit"));
	            profs.add(rs.getInt("Prof"));
	    	}
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    for(int i=0;i<courses.size();i++) {
	    	courses.get(i).setClass(new Class(Classes.get(i),database));
	    	courses.get(i).setProf(new Employee(profs.get(i)));
	    }
	    return courses;

}
