package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
@Component
public class EmployeePSS implements PreparedStatementSetter  {
	Employee emp;

	public EmployeePSS(Employee emp) {

		this.emp = emp;
	}
	public EmployeePSS() {
	
	}

	
	
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(5,emp.getEmpcode());
		pst.setString(1,emp.getEmpname());
		pst.setString(2,emp.getJob());
		pst.setDouble(3,emp.getSalary());
		pst.setDate(4,DateParsing.convertDate(emp.getDateOfBirth()));
		
	}

}
