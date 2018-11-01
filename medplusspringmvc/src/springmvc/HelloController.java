package springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
	@Autowired
	Employee employee;
	@Autowired
	EmployeeValidations ev;
	@Autowired
	Login login;
	@RequestMapping("/hello")
	public String welcome() {
		return "Welcome";
	}
	@RequestMapping("/login1")
	public String showloginpage() {
		return "Employee";
	}
	@RequestMapping(value="/addempl",method=RequestMethod.GET)
	public ModelAndView LoginPage() {
		ModelAndView mav= new ModelAndView();
		mav.addObject(employee);
		mav.setViewName("Employee");
		return mav;
	}
	@RequestMapping(value="/addempl" ,method=RequestMethod.POST)
		public ModelAndView validate(@ModelAttribute("employee") Employee emp,BindingResult result) {
		ModelAndView mav= new ModelAndView();
		ev.validate(emp,result);
		if(result.hasErrors()) {
			mav.setViewName("Employee");
			return mav;
		}
		mav.addObject("emp",emp);
		mav.setViewName("Welcome");
		return mav;
		}
}
//	@RequestMapping("/loginvalidate")
//	public String validate(@RequestParam("username") String user,@RequestParam("password") String password) {
//		if(user.equals("admin") && password.equals("admin")) {
//			return "Welcome";
//			
//		}
//		
//		return "Failed";
//	}
//	@RequestMapping("/empl")
//public String Empl(@ModelAttribute("employee") Employee employee) {
//		System.out.println(employee);
//	return "Welcome";
//}
//}
