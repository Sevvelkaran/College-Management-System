package Controller;

import java.sql.ResultSet;
import java.util.Scanner;
import Model.Database;
import Model.Operation;

public class ReadClasses implements Operation{
	@Override
	public void oper(Database database,Scanner scanner) {
		for(Class c:getAllClasses(database)) {
			c.print();
		}
	}
		
	}
    public ArrayList<Model.Class> getAllClasses(Database database){
    String select="SELECT *FROM CLASSES';";
    try {
    	ResultSet rs=database.getStatement().executeQuery(select);
    	while(rs.next()) {
    	    Class c=new Class();
        	c.setID(rs.getInt("ID"));
        	c.setName(rs.getString("Name"));
        	classes.add(c);
    	}
    }
    catch(SQL Exception e) {
    	e.printStackTrace();
    }
    return classes;
	@Override
	public void oper(Database database) {
		// TODO Auto-generated method stub
		
	}

}
