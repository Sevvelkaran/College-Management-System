package Controller;

import java.util.Scanner;

import Model.Database;
import Model.Department;
import Model.Operation;

public class DeleteDepartment implements Operation {

	@Override
	public void oper(Database database,Scanner scanner) {
		
		System.out.println("Enter Department ID (-1 to show all departments):");
		int ID=scanner.nextInt();
		
		while(ID<0) {
			new ShowAllDepartments().oper(database,scanner);
			System.out.println("Enter Department ID (-1 to show all departments):");
			int ID=scanner.nextInt();
		}
	
	
	Department department=new Department();
	d.delete(database);
   }
}
