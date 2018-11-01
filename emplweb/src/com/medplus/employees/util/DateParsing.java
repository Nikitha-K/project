package com.medplus.employees.util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParsing {
	public static Date connvertToSqlDate(java.util.Date date) {
		Date sqldate = new Date(date.getTime());
		return sqldate;
	}

	public static java.util.Date convertToUtilDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
		java.util.Date dt = null;

		try {
			dt = sdf.parse(date);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dt;

	}

}
