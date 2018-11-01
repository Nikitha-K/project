package bankingSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
@Component

public class DepositPss implements PreparedStatementSetter {
	@Autowired
	Account acc;

	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setDouble(1,acc.getBalance());
		pst.setInt(2,acc.getAccno());
		
	}
	

}
