package bankingSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class AccDetailsPss implements PreparedStatementSetter {
	
@Autowired
Account acc;
	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
	pst.setInt(1,acc.getAccno());
		
	}

}
