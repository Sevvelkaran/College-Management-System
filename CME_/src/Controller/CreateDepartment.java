package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Database;
import Model.Department;
import Model.Operation;

public class CreateDepartment implements Operation {
	
	@Override
	public void oper(Database database,Scanner scanner) {
		System.out.println("Enter Department name:");
		String deptName=scanner.nextLine();
		
		int ID=0;
		ArrayList<Department> departments= new ShowAllDepartment().getAllDepartments(database);
		if(departments.size!=0) {
			ID=departments.get(departments.size()-1).getID()+1;
		}
		Department department=new Department();
		department.setID(ID);
		department.setName(name);
		department.create(database);
	}

	public static void main(String[] args) {
		

	}

}
