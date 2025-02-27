package Controller;

import java.util.Scanner;

import Model.Database;
import Model.Operation;

public class UpdateClass implements Operation {

    public void oper(Database database, Scanner scanner) {
        System.out.println("Enter Class ID (-1 to show all classes):");
        int ID = scanner.nextInt();
        while (ID < 0) {
            new ReadClasses().oper(database, scanner);
            System.out.println("Enter Class ID (-1 to show all classes):");
            ID = scanner.nextInt();
        }

        Model.Class c = new Model.Class(ID, database);
        scanner.nextLine();
        System.out.println("Enter Class Name (-1 to keep "+c.getName()+"):");
        String name = scanner.nextLine();
    if(!name.equals("-1"))c.setName(name);    
    c.update(database);
    }

	public void oper(Database database) {
		// TODO Auto-generated method stub
		
	}
}