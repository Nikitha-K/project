package sample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDao{
	@Autowired
	Employee emp;
	@Autowired
	EmpPSS pst;
	/*@Autowired
	EmpdelPSS psc;
	@Autowired
	EmployeePSS pss;*/
	/*@Autowired
	EmployeePSS pss;*/
	
@Autowired
private JdbcTemplate template;
	public void insert() {
		String sql ="insert into employee values(333,'akhi','dev',6000,'2016-01-11')";
		template.execute(sql);
			}
	public int addEmpl(Employee emp) {
		String sql ="insert into employee values(?,?,?,?,?)";
	
		int rows = template.update(sql, new EmpPSS(emp));
		return rows;
	}
//	public int update(Employee emp) {
//		String sql ="update employee set empname=?,job=?,salary=?,dateofbirth=? where empcode=?";
//				int rows=getJdbcTemplate().update(sql,new EmployeePSS(emp));
//				
//		return rows;
//		
//	}
	public int delete(int code) {
		String sql ="delete from employee where empcode=?";
		int rows =template.update(sql,code);
		return 0;
		
		
	}
	public List<Employee> getList() {
		String sql ="select * from employee";
		List<Employee> list=template.query(sql,new BeanPropertyRowMapper<Employee>(Employee.class));
		return list;
	}
	public Employee getEmployee(int empcode) {
		String sql="select * from employee where empcode=?";
		Object args[]= {empcode};
		emp =template.queryForObject(sql,args,new BeanPropertyRowMapper<Employee>(Employee.class));
		return emp;
	}

}
