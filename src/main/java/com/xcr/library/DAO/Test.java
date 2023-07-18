package com.xcr.library.DAO;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/javalms";
        String username = "root";
        String password = "" ;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM book");
            while (rs.next())
                System.out.println(rs.getString(1)+ rs.getString(2) );

            con.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
