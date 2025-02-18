package Model;

import java.sql.SQLException;

public class Class {

	private int ID;
	private String name;
	
	public Class() {
	}
	
	public Class(int ID,Database database) {
		
	}
	
	public int getID() {
		return ID;
	}
		
	public void setID(int ID) {
		this.ID = ID;
	}
		
	public String getName() {
		return name;
	}
		
	public void setName(String name) {
		this.name=name;
	}
	public void print() {
		System.out.println("ID:\t"+ID);
		System.out.println("Name:\t"+name);
		System.out.println("_____________\n");		
	}
	
	public void create(Database database) {
		String insert="INSERT INTO 'classes'('ID','Name') VALUES"+"('"+ID+"','"+name+"');";
		
		try {
			database.getStatement().execute(insert);
			System.out.println("class created successfully");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
    }
    public void update(Database database) {
	      String update="UPDATE 'classes' SET 'Name'="+getName()+"' "
                   +"WHERE 'ID' ="+getID()+";";
	     try {
	    	 database.getStatement().execute(update);
	 		System.out.println("class updated successfully");
	 	}
	 	catch(SQLException e) {
	 		e.printStackTrace();
	 	}
	}
    public void delete(Database database) {
	      String delete="DELETE FROM 'classes' WHERE 'ID' = "+getID()+";"; 
	     try {
	    	 database.getStatement().execute(delete);
	 		System.out.println("class deleted successfully");
	 	}
	 	catch(SQLException e) {
	 		e.printStackTrace();
	 	}
	}
 }
    