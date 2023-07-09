package com.mypkg;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		try {
			
			//step1 register driver
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			// another way 
			//for error ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'admin';
			//Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2 get the database connection
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","admin");
			System.out.println(conn);
			
			//step 3 create statement
			
			Statement stmt=conn.createStatement();
			
			//DML queries
			//String insertQuery="insert into employee values(6,'gpt',4000,18,'solver',5);";
			
			//int n=stmt.executeUpdate(insertQuery);
			//String updateQuery="update employee set esal=5000  where eid=6";
			//String delQuery="delete from employee where eid=4";
			//int n=stmt.executeUpdate(delQuery);
			//System.out.println(n+" record affected");
			
			
			//Select query
			String selectQuery="select * from employee";
			ResultSet rs=stmt.executeQuery(selectQuery);
			
			while(rs.next()) {
				int eid=rs.getInt("eid");
				String ename=rs.getString("ename");
				int esal=rs.getInt("esal");
				System.out.println(eid+" "+ename+" "+esal);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
