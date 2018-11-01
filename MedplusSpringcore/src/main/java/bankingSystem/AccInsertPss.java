package bankingSystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
@Component
public class AccInsertPss implements PreparedStatementSetter {
	@Autowired
	Account acc;

	@Override
	public void setValues(PreparedStatement pst) throws SQLException {
		pst.setInt(1,acc.getAccno());
		pst.setString(2,acc.getCustname());
		pst.setDouble(3,acc.getBalance());
		pst.setDate(4,null);
	}

}
