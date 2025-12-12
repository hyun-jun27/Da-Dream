import java.io.IOException;
import java.sql.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author pcfriend
 */
public class DB_MAN {
    String strDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String strURL = "jdbc:sqlserver://10.70.41.80:1433;DatabaseName=Member;";
    String strEncrypt = "encrypt=true;trustServerCertificate=true;";
    String strUser = "sa";
    String strPWD = "inha1958";
    
    Connection DB_con;
    Statement DB_stmt;
    ResultSet DB_rs;

    public void dbOpen() throws IOException{
        try {
            Class.forName(strDriver);
            strURL += strEncrypt;
            DB_con = DriverManager.getConnection(strURL, strUser, strPWD);
            DB_stmt = DB_con.createStatement();
            System.out.println("연결 성공!");
        } catch (Exception e) {
            System.out.println("SQLException : "+e.getMessage());
        }
    }

    public void dbClose() {
        try {
            DB_stmt.close();
            DB_con.close();
        } catch (SQLException e) {
            System.out.println("SQLException : "+e.getMessage());
        }
    }
}
