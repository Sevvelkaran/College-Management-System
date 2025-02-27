package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private String user = "root";
    private String pass = "Kiot1234@";
    private String url = "jdbc:mysql://localhost:3306/COLLEGE"; 

    private Statement statement;

    public Database() {
        try {
        	 Connection con = DriverManager.getConnection(url, user, pass);
            statement = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                  ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        return statement;
    }
}