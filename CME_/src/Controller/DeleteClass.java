package Controller;

import java.util.Scanner;

import Model.Database;
import Model.Operation;
import Model.Student;

public class DeleteClass implements Operation{

		@Override
	public void oper(Database database,Scanner scanner) {
			System.out.println("Enter Class ID(-1 to show all classes)");
			int ID=scanner.nextInt();
			while(ID<0) {
				new ReadStudents().oper(database,scanner);
				System.out.println("Enter class ID(-1 to show all classes)");
				int ID=scanner.nextInt();
			}
		  Class c=new Class(ID);
		  c.delete(database);
		
		
	}

		@Override
		public void oper(Database database) {
			// TODO Auto-generated method stub
			
		}

}
