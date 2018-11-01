package com.medplus.employees.util;

public class DBQueries {
	public static String addempl = "insert into employee values (?,?,?,?,?) ";
	public static String updateempl = "update employee set empname =?,job=?,salary=?,dateofbirth=? where empcode=?";
	public static String deleteempl = "delete from employee where empcode=?";
	public static String getempdetails = "select empcode,empname,job,salary,dateofbirth from employee where empcode=?";
	public static String getlist = "select empcode,empname,job,salary,dateofbirth from employee";
}
