package Controller;

import java.util.Scanner;

import Model.Database;

public class Login {
    public static void main(String[] args) {
        Database db = new Database(); 
        new AddNewEmployee().oper(db, new Scanner(System.in));
    }
}
