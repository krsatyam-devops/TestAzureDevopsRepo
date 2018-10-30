package com.serialize.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SerializeJavaObjects_MySQL {
  static final String WRITE_OBJECT_SQL = "INSERT INTO variable(name, value) VALUES (?, ?)";

  static final String READ_OBJECT_SQL = "SELECT value FROM variable WHERE name = ?";

  public static Connection getConnection() throws Exception {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/prod_sat_db";
    String username = "root";
    String password = "Proj@Sec@root";
    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }

  public static void writeJavaObject(Connection conn, Object object) throws Exception {
    String className = object.getClass().getName();
    PreparedStatement pstmt = conn.prepareStatement(WRITE_OBJECT_SQL);
    
    GenerateHardwareId genObj = new GenerateHardwareId();
    genObj.setMacAddress("00-4f-67-98");
    genObj.setName("MAC ADDR");

    // set input parameters
    pstmt.setString(1, "Mac Address");
    pstmt.setObject(2, genObj);
    pstmt.executeUpdate();

    // get the generated key for the id
  
    pstmt.close();
    System.out.println("writeJavaObject: done serializing: " + className);
    
  }

  public static GenerateHardwareId readJavaObject(Connection conn) throws Exception {
    PreparedStatement pstmt = conn.prepareStatement(READ_OBJECT_SQL);
    pstmt.setString(1, "Mac Address");
    ResultSet rs = pstmt.executeQuery();
    rs.next();
    GenerateHardwareId object = (GenerateHardwareId) rs.getObject(1);
    System.out.println("Hello...");
    System.out.println(object.toString());
    String className = object.getClass().getName();

    rs.close();
    pstmt.close();
    System.out.println("readJavaObject: done de-serializing: " + className);
    return (GenerateHardwareId) object;
  }
  public static void main(String args[])throws Exception {
    Connection conn = null;
    try {
      conn = getConnection();
      System.out.println("conn=" + conn);
      conn.setAutoCommit(false);
      List<Object> list = new ArrayList<Object>();
      list.add("This is a short string.");
      list.add(new Integer(1234));
      list.add(new Date());

    // writeJavaObject(conn, list);
      conn.commit();
      Object obj1 =  readJavaObject(conn);
      System.out.println("[After De-Serialization] list=" + obj1.toString());
     
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      conn.close();
    }
  }
}
