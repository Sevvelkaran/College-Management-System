package Controller;

import java.util.Scanner;

import Model.Database;

public class Login {
    public static void main(String[] args) {
        Database db = new Database(); 
        new DeleteDepartment().oper(new Database(), new Scanner(System.in));
    }
}
