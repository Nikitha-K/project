package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
@Component
public class EmpPSS implements PreparedStatementSetter {
	@Autowired
	Employee emp;
	public EmpPSS(Employee emp) {
		this.emp=emp;;
	}
	

	public EmpPSS() {
		
	}


	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(1,emp.getEmpcode());
		pst.setString(2,emp.getEmpname());
		pst.setString(3,emp.getJob());
		pst.setDouble(4,emp.getSalary());
		//Date dob= DateParsing.convertDate(emp.getDateOfBirth());
		pst.setDate(5, DateParsing.convertDate(emp.getDateOfBirth()));
	
		
	}

}
