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
	@Autowired
	public EmployeeDao(DriverManagerDataSource dataSource) {
		setDataSource(dataSource);
		
	}
	public void insert() {
		String sql ="insert into employee values(333,'akhi','dev',6000,'2016-01-11')";
		getJdbcTemplate().execute(sql);
			}
	public int addEmpl() {
		String sql ="insert into employee values(?,?,?,?,?)";
		//Object[] args= {emp.getEmpcode(),emp.getEmpname(),emp.getJob(),emp.getSalary(),emp.getDateOfBirth()};
	//	int rows = getJdbcTemplate().update(sql,args);
		int rows = getJdbcTemplate().update(sql, pss);
		return rows;
	}
	public int update() {
		String sql ="update employee set empname=?,job=?,salary=?,dateofbirth=? where empcode=?";
				int rows=getJdbcTemplate().update(sql,pst);
				
		return rows;
		
	}
	public int delete() {
		String sql ="delete from employee where empcode=?";
		int rows =getJdbcTemplate().update(sql,psc);
		return 0;
		
		
	}
	public List getList() {
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
