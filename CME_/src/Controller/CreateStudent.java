package Controller;

import Model.Database;
import Model.Operation;
import Model.Student;

import java.util.*;

public class CreateStudent implements Operation {
	
	public void oper(Database database, Scanner scanner) {
		Student s = new Student();
		
		System.out.println("Enter First Name : ");
		s.setFirstName(scanner.next());
		
		System.out.println("Enter Last Name");
		s.setLastName(scanner.next());
		
		System.out.println("Enter Email");
		s.setEmail(scanner.next());
		
		System.out.println("Enter PhoneNumber");
		s.setPhoneNumber(scanner.next());
		
		System.out.println("Enter Birth Date");
		s.setBirthDate(scanner.next());
		
		System.out.println("Enter Class Id (-1 to show all classes");
		int classID = scanner.nextInt();
		
		while(class ID < 0) {
			
			new ReadClasses().oper(database, scanner);
			System.out.println("Enter Class Id (-1 to show all classes");
			classID = scanner.nextInt();
		}
		
		s.setClass(new Class(classID, database));
		
		s.create(database);
		
	}

	@Override
	public void oper(Database database) {
		// TODO Auto-generated method stub
		
	}

}
