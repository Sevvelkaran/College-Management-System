package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Database;
import Model.Operation;

public class CreateClasses implements Operation{

	public static void main(String[] args) {
		
		@Override
		public void oper(Database database,Scanner scanner) {
			System.out.println("Enter class Name:");
			String name=scanner.nextLine();
			
			ArrayList<Model.Class> classes=new ReadClasses.getAllClasses(database);
			int ID=0;
			if(classes().size!=0) {
				ID=classes.get(classes.size()-1).getID()+1;
			}
			Model.Class c=new Model.Class();
			c.setID(ID);
			c.setName(name);
			c.create(database);
			
		

	}

		@Override
		public void oper(Database database) {
			// TODO Auto-generated method stub
			
		}

}
