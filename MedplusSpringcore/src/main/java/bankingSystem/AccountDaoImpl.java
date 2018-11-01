package bankingSystem;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
	@Autowired
	AccInsertPss psc;
	@Autowired
	AddressPss apss;

	@Autowired
	public AccountDaoImpl(DriverManagerDataSource datasource) {
		setDataSource(datasource);

	}

	@Override
	public int createAccount() {
		String sql = "insert into acount values(?,?,?,?)";
		String sql1 = "insert into address values(?,?,?)";
		int rows = getJdbcTemplate().update(sql, psc);
		int rows1 = getJdbcTemplate().update(sql1, apss);

		return rows + rows1;
	}

	@Override
	public List miniStatement(int accno) {
		String sql = "select * from transaction where accno=?";
		List<Transaction> list = getJdbcTemplate().query(sql, new Object[] { accno },
				new BeanPropertyRowMapper<Transaction>(Transaction.class));
		return list;
	}

	@Override
	public int deposit(int accno, int amount) {
		String sql = "update acount set balance=? where accno=?";
		String sql1 = "insert into transaction values(?,?,?,?,?,?)";
		Account ac = getAccountdetails(accno);
		if (ac == null)
			return 0;
		double bal = ac.getBalance() + amount;
		Object args[] = { bal, ac.getAccno() };
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);
		Object args1[] = { accno,date, "deposit", amount, "null", bal };
		int rows = getJdbcTemplate().update(sql, args);
		int rows1 = getJdbcTemplate().update(sql1, args1);
		System.out.println("updated bal is " + bal);
		return rows + rows1;
	}

	@Override
	public int withdraw(int accno, int amount) {
		String sql = "update acount set balance=? where accno=?";
		String sql1 = "insert into transaction values(?,?,?,?,?,?)";
		Account ac = getAccountdetails(accno);
		if (ac == null)
			return 0;
		if (amount > ac.getBalance()) {
			System.out.println("insufficient balance");
			return 0;
		}
		double bal = ac.getBalance() - amount;
		Object args[] = { bal, ac.getAccno() };
		long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
		Object args1[] = { accno,date, "withdraw", amount, "null", bal };
		int rows = getJdbcTemplate().update(sql, args);
		int rows1 = getJdbcTemplate().update(sql1, args1);
		System.out.println("updated bal is " + bal);
		return rows + rows1;

	}

	@Override
	public Account getAccountdetails(int accno) {
		Account at = null;
		String sql = "select * from acount where accno=?";

		Object args[] = { accno };
		try {
			at = getJdbcTemplate().queryForObject(sql, args, new BeanPropertyRowMapper<Account>(Account.class));

		} catch (Exception e) {
			System.out.println("accno not found");
		}
		return at;

	}

}
