package Controller;

import java.util.Scanner;

import Model.Database;

public class Login {
    public static void main(String[] args) {
    	Scanner scanner=new Scanner(System.in);
        Database db = new Database(); 
        int selected=scanner.nextInt();
        new CreateCourse().oper(new Database(), new Scanner(System.in));
    }
}
 