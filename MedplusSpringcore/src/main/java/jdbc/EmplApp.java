package jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmplApp {
	public static void main(String[] args) {
		ApplicationContext ap = new ClassPathXmlApplicationContext("Annotations.xml");
		Employee empl1= ap.getBean("employee",Employee.class);
		EmployeeDao dao=ap.getBean("employeeDao",EmployeeDao.class);
		empl1.setEmpcode(1256141);
		empl1.setEmpname("dddddd");
		empl1.setJob("devv");
		empl1.setSalary(1212);
		empl1.setDateOfBirth("2012-11-11");
//		int rows=dao.delete();
		System.out.println("inserted");
		List<Employee> list=dao.getList();
		for(Employee e:list) {
			System.out.println(e.getEmpname());
			
		}
		empl1=dao.getEmployee(23455);
		System.out.println(empl1.getSalary());
		
	}

}
