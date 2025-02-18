package Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import Model.Database;
import Model.Department;
import Model.Operation;


public class ReadDepartments  implements Operation{
	
	
	public void oper(Database database,Scanner scanner) {
		ArrayList<Department> departments = getAllDepartments(database);
		for(Department d: departments ) {
			d.print();
		}
	}
		
		public ArrayList <Department> getAllDepartments (Database database){
			ArrayList <Department> departments = new ArrayList<>();
			String select = " SELECT * FROM `departments`; ";
			
			try {
				
				ResultSet rs = database.getStatement().executeQuery(select);
				while(rs.next()) {
					Department d = new Department();
					d.setId(rs.getInt("ID"));
					d.setName(rs.getString("Name"));
					departments.add(d);
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return departments;
		}

		@Override
		public void oper(Database database) {
			// TODO Auto-generated method stub
			
		}
	

	

}
