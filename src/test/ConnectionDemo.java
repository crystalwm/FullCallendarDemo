package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
     public static void main(String[] args)
     				throws ClassNotFoundException ,SQLException{
    	 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 String jdbcUrl="jdbc:oracle:thin:@localhost:1521:orcl";
    	 String user="research";
    	 String passwd="zhao";
    	 try{
    		 Connection conn=
    				 DriverManager.getConnection(jdbcUrl,user,passwd);
    		 System.out.printf("数据库已经%s%n",conn.isClosed()?"关闭":"打开");
    	 }
 	    catch (Exception e)
 	    {
 	      e.printStackTrace();
 	    }
     }
    	 
     }

