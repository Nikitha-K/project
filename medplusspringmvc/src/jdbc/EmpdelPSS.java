package jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
@Component
public class EmpdelPSS implements PreparedStatementSetter{
@Autowired
Employee emp;
	@Override
	public void setValues(PreparedStatement pss) throws SQLException {
		pss.setInt(1,emp.getEmpcode());
		
		
	}

}
