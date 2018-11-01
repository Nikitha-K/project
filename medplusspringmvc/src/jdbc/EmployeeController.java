package jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class EmployeeController {
	@Autowired
	Employee employee;
	@Autowired
	EmployeeDao dao;

	
	
	
	@RequestMapping(value="/addempl",method=RequestMethod.GET)
	public ModelAndView LoginPage() {
		ModelAndView mav= new ModelAndView();
		mav.addObject(employee);
		mav.setViewName("Empl");
		return mav;
	}
	@RequestMapping(value="/addempl" ,method=RequestMethod.POST)
		public ModelAndView validate(@ModelAttribute("employee") Employee emp) {
		ModelAndView mav= new ModelAndView();	
		mav.addObject("emp",emp);
		int rows =dao.addEmpl(emp);
		if(rows>0) {
			String msg=rows+"records inserted";
			mav.addObject("msg",msg);
			mav.setViewName("Welcome");

		}
		return mav;
		}
	@RequestMapping("viewempl")
	public ModelAndView employeeList() {
		ModelAndView mav = new ModelAndView();
		List<Employee> emplist=dao.getList();
		mav.addObject("list",emplist);
		mav.setViewName("ViewEmpls");
		return mav;
		
	}
	@RequestMapping("home")
	public ModelAndView homePage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("Home");
		return mav;
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public ModelAndView updateemp(@RequestParam("code") int code) {
		ModelAndView mav = new ModelAndView();
		employee =dao.getEmployee(code);
		mav.addObject("employee",employee);
		mav.setViewName("UpdateEmp");
		return mav;
	}
	@RequestMapping(value="/update" ,method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute("employee") Employee emp) {
		ModelAndView mav = new ModelAndView();
		int rows =dao.update(emp);
		if(rows>0) {
			String msg=rows+"records updated";
			mav.addObject("msg",msg);
			mav.setViewName("UpdateDone");
		}
		return mav;
		
		
	}
	@RequestMapping("delete")
	public ModelAndView deleteRequest(@RequestParam("code") int code) {
		ModelAndView mav = new ModelAndView();
		int rows =dao.delete(code);
		if(rows>0) {
			String msg=rows+"record deleted";
			mav.addObject("msg",msg);
			mav.setViewName("Delete");
		}
	
		return mav;
	}
}
