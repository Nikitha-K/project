package javacore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mysql.cj.jdbc.Driver;

public class SampleDate {
	public static void main(String[] args) throws SQLException, ParseException {
		Driver  driver= new Driver();
		DriverManager.registerDriver(driver);
		String url="jdbc:mysql://localhost:3306/medplus";
		String user="root";
		String pass="root";
		Connection conn =DriverManager.getConnection(url,user,pass);
		String sql="insert into employee values(?,?,?)";
		PreparedStatement pst = conn.prepareStatement(sql);
		String doj = "13-11-2018";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date dt =sdf.parse(doj);
		System.out.println(dt);
		java.sql.Date jsd  = new java.sql.Date(dt.getTime()) ;
		
		
	}

}
