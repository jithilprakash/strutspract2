package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class JdbcUtil{
    public static final String driver = "oracle.jdbc.driver.OracleDriver";
    public static final String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    public static final String password = "hr";
    public static final String username = "hr";
    static{
        try {
           Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = (Connection) DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void Release(ResultSet rs,Statement stmt,Connection conn){
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    public static void release(Object o){
        try{
            if(o instanceof ResultSet){
                ((ResultSet)o).close();
            }else if(o instanceof Statement){
                ((Statement)o).close();
            }else if(o instanceof Connection){
                ((Connection)o).close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

