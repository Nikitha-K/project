package jdbc;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateParsing {
//	public static Date connvertToSqlDate(java.util.Date dob) {
//		Date sqldate = new Date(dob.getTime());
//		return sqldate;
//	}

	public static Date convertDate(String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date sqldate= null;
		java.util.Date dt = null;

		try {
			dt = sdf.parse(date);
			sqldate = new Date(dt.getTime());

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sqldate;

	}
	

}
