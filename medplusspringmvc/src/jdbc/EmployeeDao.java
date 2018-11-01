package jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao extends JdbcDaoSupport {
	@Autowired
	Employee emp;
	@Autowired
	EmpPSS pst;
	@Autowired
	EmpdelPSS psc;
	@Autowired
	EmployeePSS pss;
	/*@Autowired
	EmployeePSS pss;*/
	@Autowired
	public EmployeeDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
		
	}
	public void insert() {
		String sql ="insert into employee values(333,'akhi','dev',6000,'2016-01-11')";
		getJdbcTemplate().execute(sql);
			}
	public int addEmpl(Employee emp) {
		String sql ="insert into employee values(?,?,?,?,?)";
	
		int rows = getJdbcTemplate().update(sql, new EmpPSS(emp));
		return rows;
	}
	public int update(Employee emp) {
		String sql ="update employee set empname=?,job=?,salary=?,dateofbirth=? where empcode=?";
				int rows=getJdbcTemplate().update(sql,new EmployeePSS(emp));
				
		return rows;
		
	}
	public int delete(int code) {
		String sql ="delete from employee where empcode=?";
		int rows =getJdbcTemplate().update(sql,code);
		return 0;
		
		
	}
	public List<Employee> getList() {
		String sql ="select * from employee";
		List<Employee> list=getJdbcTemplate().query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}
	public Employee getEmployee(int empcode) {
		String sql="select * from employee where empcode=?";
		Object args[]= {empcode};
		emp =getJdbcTemplate().queryForObject(sql,args,new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}

}
