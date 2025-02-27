package Controller;

import java.util.Scanner;

import Model.Database;
import Model.Operation;

public class DeleteClass implements Operation{


	public void oper(Database database,Scanner scanner) {
		System.out.println("Enter Class ID (-1 to show all classes):");
        int ID = scanner.nextInt();
        while (ID < 0) {
            new ReadClasses().oper(database, scanner);
            System.out.println("Enter Class ID (-1 to show all classes):");
            ID = scanner.nextInt();
        }
Model.Class c = new Model.Class(ID);
c.delete(database);
		
	}

	public void oper(Database database) {
		// TODO Auto-generated method stub
		
	}

}
