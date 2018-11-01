package javacore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;



public class Samplejdbc {
	public static void main(String[] args) throws SQLException {
		Driver  driver= new Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://localhost:3306/medplus";
		String user="root";
		String pass="root";
		Connection conn =DriverManager.getConnection(url,user,pass);
		String sql="insert into employee values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		String sql1 ="update employee set name =? where code =?";
		String sql2 ="select * from employee";
		String sql3 ="delete from employee where empcode =?";
		
		//pst= conn.prepareStatement(sql1);
//		pst.setInt(1,111);
//		pst.setString(2,"medplus");
//		pst.setDouble(3,2000.22);
		pst=conn.prepareStatement(sql3);
//		pst.setString(1,"akhil");
//		pst.setInt(2, 111);
	//	ResultSet rs = pst.executeQuery();
//		if(rows >0) {
//			System.out.println("inserted");
//			
//		}else 
//			System.out.println("not inserted");
//		
//		while(rs.next()) {
//			System.out.println(rs.getInt(1));
//			System.out.println(rs.getString(2));
//			System.out.println(rs.getDouble(3));
//		}
//		
		pst.setInt(1,111);
		int rows=pst.executeUpdate();
		if(rows>0) {
			System.out.println("deleted");
		}
		else System.out.println("not deleted");
	}

}
 