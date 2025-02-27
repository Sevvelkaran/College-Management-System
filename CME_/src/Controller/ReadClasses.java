package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Database;
import Model.Operation;
public class ReadClasses implements Operation{
	public void oper(Database database,Scanner scanner) {
		for(Model.Class c : getAllClasses(database)) {
			c.print();
		}
	}

	@Override
	public void oper(Database database) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<Model.Class> getAllClasses(Database database) {
	    ArrayList<Model.Class> classes = new ArrayList<>();
	    String select = "SELECT * FROM classes;";
	    try {
	        ResultSet rs = database.getStatement().executeQuery(select);
	        while(rs.next()) {
	        Model.Class c = new Model.Class();
	        c.setID(rs.getInt("ID"));
	        c.setName(rs.getString("Name"));
	        classes.add(c);
	        }
	    }
	    catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    return classes;
	}
	
}
